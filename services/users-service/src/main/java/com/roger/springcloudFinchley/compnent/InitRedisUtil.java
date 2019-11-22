package com.roger.springcloudFinchley.compnent;

import com.roger.springcloudFinchley.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2019/11/22.
 */
@Component
public class InitRedisUtil {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Bean("userServiceRedisUtil")
    public RedisUtil userServiceRedisUtil(){
        return new RedisUtil(redisTemplate);
    }

}
