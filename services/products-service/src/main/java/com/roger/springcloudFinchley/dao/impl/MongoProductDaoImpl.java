package com.roger.springcloudFinchley.dao.impl;

import com.roger.springcloudFinchley.dao.MongoProductDao;
import com.roger.springcloudFinchley.entity.MongoProducts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2019/10/17.
 */
@Service
@Slf4j
public class MongoProductDaoImpl implements MongoProductDao{
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveProduct(MongoProducts products) {
        mongoTemplate.insert(products);
    }
}
