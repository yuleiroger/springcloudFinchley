package com.roger.springcloudFinchley.config;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by admin on 2019/12/4.
 */
@Configuration
public class SybnHystrixFeignConfiguration {
    @Bean
    @Scope("prototype")
    public Feign.Builder feignHystrixBuilder() {
        return Feign.builder();
    }
}
