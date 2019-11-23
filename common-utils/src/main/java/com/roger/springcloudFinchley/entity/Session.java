package com.roger.springcloudFinchley.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by yulei on 2019/11/23.
 */

public class Session implements Serializable{
    private static Session instance = new Session();
    private static String sessionId = UUID.randomUUID().toString();
    private ConcurrentMap<String, Object> attribute = new ConcurrentHashMap<>();

    private Session(){

    }

    public static Session getSessionInstance(){
        return instance;
    }

    public String getSessionId() {
        return sessionId;
    }

    public Object getAttribute(String key) {
        return attribute.get(key);
    }

    public void setAttribute(String key, Object value) {
        attribute.putIfAbsent(key, value);
    }
}
