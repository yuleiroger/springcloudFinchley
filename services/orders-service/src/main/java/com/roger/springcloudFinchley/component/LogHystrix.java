package com.roger.springcloudFinchley.component;

import com.roger.springcloudFinchley.service.LogFeignService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2019/12/4.
 */
@Component
public class LogHystrix implements LogFeignService{
    @Override
    public Object getLogsList() {
        List<String> list = new ArrayList<>();
        list.add("new");
        return list;
    }
}
