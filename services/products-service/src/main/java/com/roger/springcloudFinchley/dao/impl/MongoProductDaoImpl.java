package com.roger.springcloudFinchley.dao.impl;

import com.roger.springcloudFinchley.dao.MongoProductDao;
import com.roger.springcloudFinchley.entity.MongoProducts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

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

    /**
     * 这个是精确查询，相当于where =
     * @return
     */
    @Override
    public List<MongoProducts> queryMongoProducts() {
        //用来封装所有条件的对象
        Query query = new Query();
        //用来构建条件
        Criteria criteria = new Criteria();
        /**
         * 这里使用的正则表达式的方式
         * 第二个参数Pattern.CASE_INSENSITIVE是对字符大小写不明感匹配
         */
        query.addCriteria(criteria.and("product_name").is("书"));

        List<MongoProducts> list = mongoTemplate.find(query, MongoProducts.class, "tb_products");
        log.info("{}",list.size());
        return list;
    }

    @Override
    public List<MongoProducts> queryProductLike(String name) {
        //用来封装所有条件的对象,模糊查询
        Query query = new Query();
        String pattern_name = name;
        Pattern pattern=Pattern.compile("^.*" + pattern_name+".*$", Pattern.CASE_INSENSITIVE);
        query.addCriteria(Criteria.where("product_name").regex(pattern));
        List<MongoProducts> list = mongoTemplate.find(query, MongoProducts.class, "tb_products");
        log.info("{}",list.get(0));
        return list;
    }

    @Override
    public void remove(){
        Query query = Query.query(Criteria.where("product_name").is("书"));
        mongoTemplate.remove(query, MongoProducts.class);
    }

    @Override
    public MongoProducts update(){
        Query query = new Query();
        query.addCriteria(Criteria.where("product_name").is("数据库入门与实践"));
        Update update = new Update();
        update.set("product_name", "nosql数据库入门与实践");
        MongoProducts products = mongoTemplate.findAndModify(query, update, MongoProducts.class);
        return products;
    }
}
