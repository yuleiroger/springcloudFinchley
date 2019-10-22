package com.roger.springcloudFinchley.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2019/10/22.
 */
@RestController
public class OrdersController {

    @GetMapping(value = "getOrder")
    public String getOrder(){
        return "get order";
    }
}
