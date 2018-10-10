package com.itheima.observer.impl;

import com.itheima.observer.Observer;
import com.itheima.observer.Subject;

/**
 * 模拟使用者2
 */
public class Observer2 implements Observer {
    private Subject subject;
    
    public Observer2(Subject subject) {
        this.subject = subject;
        subject.registObserver(this);
    }
    
    @Override
    public void update(String msg) {
        System.out.println("Observer2 得到 3D 号码 -->" + msg + "我要告诉舍友们。");
    }
}
