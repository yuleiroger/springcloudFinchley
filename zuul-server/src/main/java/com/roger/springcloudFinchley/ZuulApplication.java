package com.roger.springcloudFinchley;

import com.roger.springcloudFinchley.config.MyRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by admin on 2019/10/10.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@RibbonClient(name = "myLoadBalance", configuration = MyRuleConfig.class)
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
