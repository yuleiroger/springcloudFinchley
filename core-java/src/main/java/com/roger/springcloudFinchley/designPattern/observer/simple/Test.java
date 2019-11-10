package com.roger.springcloudFinchley.designPattern.observer.simple;

/**
 * Created by yulei on 2019/11/9.
 */
public class Test {
    public static void main(String[] args) {
        IObserver obs = new Observer();
        ISubject subject = new Subject();
        subject.register(obs);
        subject.setData("hello");
        subject.notifyObservers();
    }
}
