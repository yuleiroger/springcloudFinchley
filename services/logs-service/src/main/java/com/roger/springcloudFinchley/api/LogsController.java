package com.roger.springcloudFinchley.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2019/11/25.
 */
@RestController
@Slf4j
public class LogsController {
    @GetMapping(value = "getSession")
    public Object getOrder(HttpSession session){
        return session.getAttribute("sessionValue");
    }

    @GetMapping(value = "getLogsList")
    public Object getLogsList(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            list.add("num" + i);
        }
        log.info("feign provider=={}",list);
        //throw new RuntimeException("服务端测试异常！");
        return list;
    }
}
