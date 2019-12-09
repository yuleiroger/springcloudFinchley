package com.roger.springcloudFinchley.entity;

import java.io.Serializable;

/**
 * Created by admin on 2019/12/6.
 */
public class Role implements Serializable {
    private static final long serialVersionUID = 7427463966780892351L;
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
