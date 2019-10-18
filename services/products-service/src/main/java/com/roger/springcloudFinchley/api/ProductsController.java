package com.roger.springcloudFinchley.api;

import com.roger.springcloudFinchley.entity.MongoProducts;
import com.roger.springcloudFinchley.service.MongoProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2019/10/17.
 */
@RestController
public class ProductsController {
    @Autowired
    private MongoProductService mongoProductService;

    @GetMapping(value = "/saveProducts")
    public String products(){
        MongoProducts products = new MongoProducts();
        products.setProductNo("001");
        products.setProductName("书");
        mongoProductService.saveMongoProduct(products);
        return "products success";
    }
}
