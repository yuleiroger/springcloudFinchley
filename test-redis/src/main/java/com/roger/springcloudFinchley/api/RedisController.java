package com.roger.springcloudFinchley.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by admin on 2019/11/25.
 */
@RestController
public class RedisController {
    @GetMapping("getSession")
    public Object getSession(HttpSession session){
        return session.getAttribute("sessionValue");
    }
}
