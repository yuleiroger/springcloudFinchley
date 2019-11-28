package com.roger.springcloudFinchley.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2019/11/25.
 */
@Component
public class CommonPool2Properties {
    @Value("${lettuce.pool.maxTotal}")
    private Integer maxTotal;

    @Value("${lettuce.pool.maxIdle}")
    private Integer maxIdle;

    @Value("${lettuce.pool.minIdle}")
    private Integer minIdle;

    //TODO 其他属性

    public Integer getMaxTotal() {
        return maxTotal;
    }

    public Integer getMaxIdle() {
        return maxIdle;
    }

    public Integer getMinIdle() {
        return minIdle;
    }

}

