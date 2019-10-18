package com.roger.springcloudFinchley.dao;

import com.roger.springcloudFinchley.entity.MongoUsers;

import java.util.List;

/**
 * Created by admin on 2019/9/12.
 */
public interface MongoUserDao {

    void saveUser(MongoUsers mongoUsers);

    List queryUser(MongoUsers mongoUsers);

    List queryUserLike();
}
