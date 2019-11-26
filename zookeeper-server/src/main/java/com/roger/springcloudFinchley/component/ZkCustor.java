package com.roger.springcloudFinchley.component;


import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * Created by yulei on 2019/11/10.
 */
//@Component
public class ZkCustor {
    private CuratorFramework client = null;
    public static final String ZOOKEEPER_SERVER = "192.168.190.134:2181";

    public static final Logger log = LoggerFactory.getLogger(ZkCustor.class);

    public void init(){
        if(client != null){
            return;
        }
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 5);
        client = CuratorFrameworkFactory.builder().connectString(ZOOKEEPER_SERVER)
                  .sessionTimeoutMs(10000)
                  .retryPolicy(retryPolicy)
                  .namespace("admin")
                  .build();

        client.start();

        try{
            if(client.checkExists().forPath("/bgm") == null){
                client.create().creatingParentContainersIfNeeded()
                        .withMode(CreateMode.PERSISTENT)
                        .withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
                        .forPath("/bgm");
                log.info("init success");
            }
        }catch(Exception e){

            e.printStackTrace();
        }

    }
}
