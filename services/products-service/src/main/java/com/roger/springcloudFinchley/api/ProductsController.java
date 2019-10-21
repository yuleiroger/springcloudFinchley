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
        products.setProductNo("002");
        products.setProductName("数据库入门与实践");
        mongoProductService.saveMongoProduct(products);
        return "products success";
    }

    @GetMapping(value = "/queryProducts")
    public String queryMongoProducts(){
        mongoProductService.queryMongoProducts();
        return "query success";
    }

    @GetMapping(value = "/queryProductLike")
    public String queryMongoProductsLike(){
        mongoProductService.queryProductLike("数据");
        return "query success";
    }

    @GetMapping(value = "/remove")
    public String remove(){
        mongoProductService.remove();
        return "remove success";
    }

    @GetMapping(value = "/update")
    public String update(){
        mongoProductService.update();
        return "update success";
    }
}
