package com.roger.springcloudFinchley.config;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by admin on 2019/11/26.
 */
@Configuration
public class ZookeeperConf {
    private String zkUrl = "192.168.100.129:2181,192.168.100.129:2182,192.168.100.129:2183";

    @Bean("curatorClient")
    public CuratorFramework getCuratorFramework(){
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient(zkUrl, retryPolicy);
        client.start();
        return client;
    }
}
