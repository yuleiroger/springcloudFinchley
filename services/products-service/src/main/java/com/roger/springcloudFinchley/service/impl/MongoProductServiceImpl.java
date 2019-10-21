package com.roger.springcloudFinchley.service.impl;

import com.roger.springcloudFinchley.dao.MongoProductDao;
import com.roger.springcloudFinchley.entity.MongoProducts;
import com.roger.springcloudFinchley.service.MongoProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2019/10/17.
 */
@Service
@Slf4j
public class MongoProductServiceImpl implements MongoProductService{
    @Autowired
    private MongoProductDao mongoProductDao;

    @Override
    public void saveMongoProduct(MongoProducts products) {
        mongoProductDao.saveProduct(products);
    }

    @Override
    public List<MongoProducts> queryMongoProducts() {
        return mongoProductDao.queryMongoProducts();
    }

    @Override
    public List<MongoProducts> queryProductLike(String name) {
        return mongoProductDao.queryProductLike(name);
    }

    @Override
    public void remove(){
        mongoProductDao.remove();
    }

    @Override
    public MongoProducts update() {
        return mongoProductDao.update();
    }
}
