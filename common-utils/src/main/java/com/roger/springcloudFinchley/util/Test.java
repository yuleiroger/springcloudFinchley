package com.roger.springcloudFinchley.util;

import com.roger.springcloudFinchley.entity.Session;

/**
 * Created by yulei on 2019/11/23.
 */
public class Test {
    public static void main(String[] args) {
        Session session = Session.getSessionInstance();
        session.setAttribute("user", "sessionValue");
        String value = session.getAttribute("user").toString();
        System.err.println(session.getSessionId());
        System.err.println(value);
    }
}
