package com.roger.springcloudFinchley.service;

import com.roger.springcloudFinchley.component.LogHystrix;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by admin on 2019/12/4.
 */
@FeignClient(name = "logs-service", fallback = LogHystrix.class)
public interface LogFeignService {
    @RequestMapping(value = "/getLogsList", method = {RequestMethod.GET})
    Object getLogsList();
}
