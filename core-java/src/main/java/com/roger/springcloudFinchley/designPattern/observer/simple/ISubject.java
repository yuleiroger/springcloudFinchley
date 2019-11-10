package com.roger.springcloudFinchley.designPattern.observer.simple;

/**
 * Created by yulei on 2019/11/9.
 */
public interface ISubject {
    void register(IObserver obs);//注册观察者
    void unregister(IObserver obs);//注销观察者
    void notifyObservers();//通知所有观察者
    void setData(String data);
}
