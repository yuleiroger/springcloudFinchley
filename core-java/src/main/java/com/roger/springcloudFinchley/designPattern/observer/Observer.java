package com.roger.springcloudFinchley.designPattern.observer;


/**
 * Created by yulei on 2019/11/9.
 */
public class Observer implements IObserver{
    @Override
    public void refresh(String data) {
        System.out.println("I have received the data:" + data);
    }
}
