package com.roger.springcloudFinchley.interceptor;

/**
 * Created by admin on 2019/12/10.
 */
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.roger.springcloudFinchley.annotation.LocalLock;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * 本章先基于 本地缓存来做，后续讲解 redis 方案
 *
 * @author Levin
 * @since 2018/6/12 0012
 */
@Aspect
@Configuration
@Slf4j
public class LockMethodInterceptor {

    private static final Cache<String, Object> CACHES = CacheBuilder.newBuilder()
            // 最大缓存 100 个
            .maximumSize(1000)
            // 设置写缓存后 5 秒钟过期
            .expireAfterWrite(5, TimeUnit.SECONDS)
            .build();

    @Around("execution(public * *(..)) && @annotation(com.roger.springcloudFinchley.annotation.LocalLock)")
    public Object interceptor(ProceedingJoinPoint pjp) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        log.info("ARGS : " + Arrays.toString(pjp.getArgs()));
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        LocalLock localLock = method.getAnnotation(LocalLock.class);
        String key = getKey(localLock.key(), pjp.getArgs());
        if (!StringUtils.isEmpty(key)) {
            if (CACHES.getIfPresent(key) != null) {
                throw new RuntimeException("请勿重复请求");
            }
            // 如果是第一次请求,就将 key 当前对象压入缓存中
            CACHES.put(key, key);
        }
        try {
            return pjp.proceed();
        } catch (Throwable throwable) {
            throw new RuntimeException("服务器异常");
        } finally {
            CACHES.invalidate(key);
        }
    }

    /**
     * key 的生成策略,如果想灵活可以写成接口与实现类的方式（TODO 后续讲解）
     *
     * @param keyExpress 表达式
     * @param args       参数
     * @return 生成的key
     */
    private String getKey(String keyExpress, Object[] args) {
        for (int i = 0; i < args.length; i++) {
            keyExpress = keyExpress.replace("arg[" + i + "]", args[i].toString());
        }
        return keyExpress;
    }
}
