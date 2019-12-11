package com.roger.springcloudFinchley.api;

import com.roger.springcloudFinchley.annotation.LocalLock;
import com.roger.springcloudFinchley.component.Users;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by admin on 2019/11/25.
 */
@RestController
public class RedisController {

    @LocalLock(key = "book:arg[0]")
    @GetMapping(value = "/query")
    public String query(@RequestParam String token) {
        return "success - " + token;
    }

}
