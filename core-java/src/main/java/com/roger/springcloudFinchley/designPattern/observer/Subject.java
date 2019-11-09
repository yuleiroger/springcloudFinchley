package com.roger.springcloudFinchley.designPattern.observer;

import java.util.Vector;

/**
 * Created by yulei on 2019/11/9.
 */
public class Subject implements ISubject{
    private Vector<IObserver> vec = new Vector<>();//观察者维护向量
    private String data; //主题中心数据

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public void register(IObserver obs) {
        vec.add(obs);
    }

    @Override
    public void unregister(IObserver obs) {
        if(vec.contains(obs)){
            vec.remove(obs);
        }
    }

    @Override
    public void notifyObservers() {
        for(int i = 0; i < vec.size(); i++){
            IObserver obs = vec.get(i);
            obs.refresh(data);
        }
    }
}
