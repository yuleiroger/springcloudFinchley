package com.roger.springcloudFinchley.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Created by admin on 2019/10/22.
 */
@RestController
public class OrdersController {

    @GetMapping(value = "setSession")
    public Object setSession(HttpServletRequest request){

        return "success";
    }

    @GetMapping(value = "getSession")
    public String getSession(){
        return "success";
    }

}
