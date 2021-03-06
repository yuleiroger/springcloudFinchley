package com.roger.springcloudFinchley;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by admin on 2019/10/10.
 */
@SpringBootApplication
@EnableEurekaServer
public class Eureka1Application {
    public static void main(String[] args) {
        SpringApplication.run(Eureka1Application.class, args);
    }
}
