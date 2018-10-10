package com.itheima.observer.impl;

import com.itheima.observer.Observer;
import com.itheima.observer.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * 以3D彩票服务号为例，实现主题接口
 */
public class SubjectFor3D implements Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    
    /**
     * 3D 彩票的号码
     */
    private String msg;
    
    @Override
    public void registObserver(Observer observer) {
        observers.add(observer);
    }
    
    @Override
    public void removeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        if (index > 0){
            observers.remove(observer);
        }
    }
    
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(msg);
        }
    }
    
    /**
     * 主题更新信息
     * @param msg
     */
    public void setMsg(String msg){
        this.msg = msg;
        notifyObservers();
    }
    
    
}
