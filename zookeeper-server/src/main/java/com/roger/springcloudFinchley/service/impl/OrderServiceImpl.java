package com.roger.springcloudFinchley.service.impl;

import com.roger.springcloudFinchley.service.OrderService;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 2019/11/26.
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    CuratorFramework curatorClient;
    String lockPath = "/lock/order";

    @Override
    public void makeOrderType(String type) {
        String path = lockPath + "/" + type;
        InterProcessMutex lock = new InterProcessMutex(curatorClient, path);
        try{
            if (lock.acquire(10, TimeUnit.HOURS)){
                try {
                    //TODO 实际业务处理
                } finally {
                    lock.release();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
