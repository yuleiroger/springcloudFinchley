package com.roger.springcloudFinchley.dao.impl;

import com.roger.springcloudFinchley.entity.MongoUsers;
import com.roger.springcloudFinchley.dao.MongoUserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by admin on 2019/9/12.
 * https://blog.csdn.net/qq_41402200/article/details/82149110
 * https://blog.csdn.net/qq_31868149/article/details/82908628
 */
@Service
@Slf4j
public class MongoUserDaoImpl implements MongoUserDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveUser(MongoUsers mongoUsers) {
        mongoTemplate.insert(mongoUsers);
    }

    @Override
    public List queryUser(MongoUsers mongoUsers) {
        //用来封装所有条件的对象
        Query query = new Query();
        //用来构建条件
        Criteria criteria = new Criteria();
/**
 * 这里使用的正则表达式的方式
 * 第二个参数Pattern.CASE_INSENSITIVE是对字符大小写不明感匹配
 */
        query.addCriteria(criteria.and("user_name").is("you"));

        List list = mongoTemplate.find(query, MongoUsers.class, "tb_users");

        log.info(list.size() + "");
        return list;
    }

    @Override
    public List queryUserLike() {
        //用来封装所有条件的对象,模糊查询
        Query query = new Query();
        String pattern_name = "m";
        Pattern pattern=Pattern.compile("^.*"+pattern_name+".*$", Pattern.CASE_INSENSITIVE);
        query.addCriteria(Criteria.where("user_name").regex(pattern));
        List list = mongoTemplate.find(query, MongoUsers.class, "tb_users");
        System.out.println(list.size());
        return list;
    }
}
