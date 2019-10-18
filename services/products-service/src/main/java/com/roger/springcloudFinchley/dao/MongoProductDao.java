package com.roger.springcloudFinchley.dao;

import com.roger.springcloudFinchley.entity.MongoProducts;

/**
 * Created by admin on 2019/10/17.
 */
public interface MongoProductDao {

    void saveProduct(MongoProducts products);
}
