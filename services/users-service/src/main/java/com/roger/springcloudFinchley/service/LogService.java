package com.roger.springcloudFinchley.service;

import com.roger.springcloudFinchley.entity.TbUsers;

import java.util.List;

/**
 * Created by admin on 2019/10/11.
 */
public interface LogService {
    TbUsers saveLog(String msg) throws Exception;

    void removeFromRedisList(String key, Object object);

    List findMongoUser();

    List findRedisList(String key, long begin, long end);
}
