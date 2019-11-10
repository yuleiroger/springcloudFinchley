package com.roger.springcloudFinchley;

import com.roger.springcloudFinchley.component.ZkCustor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by yulei on 2019/11/9.
 */
@SpringBootApplication
public class ZkApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZkApplication.class, args);
    }

    @Bean(initMethod = "init")
    public ZkCustor zkCustor(){
        return new ZkCustor();
    }
}
