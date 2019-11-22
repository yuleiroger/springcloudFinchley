package com.roger.springcloudFinchley.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by admin on 2019/10/22.
 */
@RestController
public class OrdersController {

    @GetMapping(value = "getOrder")
    public Object getOrder(HttpServletRequest request){
        HttpSession session = request.getSession();
        return session.getAttribute("user");
    }
}
