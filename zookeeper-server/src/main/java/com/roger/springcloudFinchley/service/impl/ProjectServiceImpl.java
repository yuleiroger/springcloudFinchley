package com.roger.springcloudFinchley.service.impl;

import com.roger.springcloudFinchley.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

/**
 * Created by admin on 2019/12/5.
 */
@Service
public class ProjectServiceImpl implements ProjectService{
    // 同时并发的线程数
    private static final int NUM = 10;
    // 按照线程数初始化倒计数器,倒计数器
    private static CountDownLatch cdl = new CountDownLatch(NUM);

    @Override
    public void updateProject() {

    }
}
