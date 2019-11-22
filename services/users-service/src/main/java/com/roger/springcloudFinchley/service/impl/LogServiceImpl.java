package com.roger.springcloudFinchley.service.impl;

import com.roger.springcloudFinchley.entity.TbUsers;
import com.roger.springcloudFinchley.dao.MongoUserDao;
import com.roger.springcloudFinchley.rabbitmq.RabbitmqSender;
import com.roger.springcloudFinchley.service.LogService;
import com.roger.springcloudFinchley.util.MD5Util;
import com.roger.springcloudFinchley.util.RedisUtil;
import com.roger.springcloudFinchley.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by admin on 2019/10/11.
 */
@Service
@Slf4j
public class LogServiceImpl implements LogService{

    @Autowired
    private RabbitmqSender rabbitmqSender;

    @Autowired
    private MongoUserDao mongoUserDao;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private RedisUtil userServiceRedisUtil = new RedisUtil(redisTemplate);

    @Override
    public TbUsers saveLog(String msg) throws Exception {
        log.info("user send msg {}",msg);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                rabbitmqSender.send(msg);
            }
        });

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 5; i++){
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    rabbitmqSender.send(msg);
                }
            });
        }

        //save data to redis
        TbUsers users = new TbUsers();
        users.setUuid(StringUtil.getUUID());
        users.setPassword(MD5Util.md5Encode("123"));
        users.setStatus("1");
        users.setUserName(StringUtil.getRandomString(4));
        userServiceRedisUtil.setList("tb_users",users, 60L);
        return users;
    }

    @Override
    public List findMongoUser() {
        List list = mongoUserDao.queryUserLike();
        return list;
    }

    @Override
    public List findRedisList(String key, long begin, long end) {
        List list = userServiceRedisUtil.getList(key, begin, end);
        log.info("list size:{}", list.size());
        for(int i = 0; i < list.size(); i++){
            log.info(list.get(i) + "");
        }
        return list;
    }

    @Override
    public void removeFromRedisList(String key, Object object) {
        userServiceRedisUtil.removeFromList(key, object);
    }
}
