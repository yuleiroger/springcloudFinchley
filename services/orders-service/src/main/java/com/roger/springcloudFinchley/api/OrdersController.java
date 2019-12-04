package com.roger.springcloudFinchley.api;

import com.roger.springcloudFinchley.service.LogFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

/**
 * Created by admin on 2019/10/22.
 */
@RestController
@Slf4j
public class OrdersController {
    @Autowired
    private LogFeignService logFeignService;

    @PostMapping(value = "/login")
    public String login(@RequestBody String params) throws Exception{
        log.info("login params is:{}", params);

        return "success";
    }

    @GetMapping(value = "setSession")
    public Object setSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        String sessionValue = UUID.randomUUID().toString();
        session.setAttribute("sessionValue",sessionValue);
        return sessionValue;
    }




}
