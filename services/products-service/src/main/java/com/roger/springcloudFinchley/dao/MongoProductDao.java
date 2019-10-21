package com.roger.springcloudFinchley.dao;

import com.roger.springcloudFinchley.entity.MongoProducts;

import java.util.List;

/**
 * Created by admin on 2019/10/17.
 */
public interface MongoProductDao {

    void saveProduct(MongoProducts products);

    List<MongoProducts> queryMongoProducts();

    List<MongoProducts> queryProductLike(String name);

    void remove();

    MongoProducts update();
}
