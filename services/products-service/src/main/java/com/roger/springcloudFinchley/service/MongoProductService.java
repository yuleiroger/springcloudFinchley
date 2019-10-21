package com.roger.springcloudFinchley.service;

import com.roger.springcloudFinchley.entity.MongoProducts;

import java.util.List;

/**
 * Created by admin on 2019/10/17.
 */
public interface MongoProductService {
    void saveMongoProduct(MongoProducts products);

    List<MongoProducts> queryMongoProducts();

    List<MongoProducts> queryProductLike(String name);

    void remove();

    MongoProducts update();
}
