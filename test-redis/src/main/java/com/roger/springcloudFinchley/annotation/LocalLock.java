package com.roger.springcloudFinchley.annotation;

import java.lang.annotation.*;

/**
 * Created by admin on 2019/12/10.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LocalLock {

    /**
     * @author fly
     */
    String key() default "";

    /**
     * 过期时间 TODO 由于用的 guava 暂时就忽略这属性吧 集成 redis 需要用到
     *
     * @author fly
     */
    int expire() default 5;
}
