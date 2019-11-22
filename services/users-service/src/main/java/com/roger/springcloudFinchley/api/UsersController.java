package com.roger.springcloudFinchley.api;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.roger.springcloudFinchley.entity.TbUsers;
import com.roger.springcloudFinchley.service.LogService;
import com.roger.springcloudFinchley.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by admin on 2019/10/10.
 */
@RestController
@Slf4j
public class UsersController {
    @Autowired
    private LogService logService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request) throws Exception{
        String userNo = request.getParameter("userNo");
        log.info("parameter user_no is:{}", userNo);
        TbUsers user = logService.saveLog("msg");
        return StringUtil.javabeanToJson(user);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String remove(HttpServletRequest request) throws Exception{
        TbUsers users = new TbUsers();
        users.setUuid("76a609a5-0a35-4481-85dc-0389b8272d06");
        log.info("remove user is:{}", users.toString());
        logService.removeFromRedisList("tb_users", users);
        return "remove success";
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String find(){
        List list = logService.findMongoUser();
        log.info("login system:{}",list.size()+"");
        return "login success";
    }

    @RequestMapping(value = "/findRedisList", method = RequestMethod.GET)
    public String findRedisList(){
        logService.findRedisList("tb_users", 0L, -1L);
        return "login success";
    }

    @HystrixCommand(fallbackMethod = "error", commandProperties = {
            @HystrixProperty(name="execution.isolation.strategy", value = "THREAD"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "40")
    }, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "1"),
            @HystrixProperty(name = "maxQueueSize", value = "10"),
            @HystrixProperty(name = "keepAliveTimeMinutes", value = "1000"),
            @HystrixProperty(name = "queueSizeRejectionThreshold", value = "8"),
            @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1440")
    })
    @RequestMapping(value = "/hello",method = {RequestMethod.GET})
    public String hello() throws Exception{
        //int i = 1/0;
        //Thread.sleep(3000);
        return "Welcome Hystrix";
    }

    public String error() {
        return "Request fails. It takes long time to response";
    }
}
