package com.roger.springcloudFinchley.component;

import com.roger.springcloudFinchley.service.LogFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2019/12/4.
 */
@Component
@Slf4j
public class LogsInit {
    @Autowired
    private LogFeignService logFeignService;

    @Bean
    public Object getProduct(){
        Object obj = logFeignService.getLogsList();
        log.info("feign client result=={}", obj);
        return null;
    }
}
