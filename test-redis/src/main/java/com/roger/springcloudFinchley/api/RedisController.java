package com.roger.springcloudFinchley.api;

import com.roger.springcloudFinchley.component.Users;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by admin on 2019/11/25.
 */
@RestController
public class RedisController {
    @GetMapping(value = "validate")
    public Object getSession(@Validated Users users,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "fail";
        }
        return "success";
    }

    public String validate(@Validated Users foo, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "fail";
        }
        return "success";
    }
}
