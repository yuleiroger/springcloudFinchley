package com.roger.springcloudFinchley;

import com.roger.springcloudFinchley.component.ZkCustor;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by yulei on 2019/11/9.
 */
@SpringBootApplication
public class ZkApplication {
    @Autowired
    CuratorFramework curatorClient;

    public static void main(String[] args) {
        SpringApplication.run(ZkApplication.class, args);
    }

    @Bean
    public String zkCustor(){
        try {
            curatorClient.create().forPath("/head", new byte[0]);
            curatorClient.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath("/head/child", new byte[0]);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "success";
    }
}
