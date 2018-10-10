package com.itheima.observer.impl;

import com.itheima.observer.Observer;
import com.itheima.observer.Subject;

/**
 * 模拟使用者1
 */
public class Observer1 implements Observer {
    private Subject subject;
    /**
     * 调用有参构造，注册用户
     * @param subject
     */
    public Observer1(Subject subject) {
        this.subject = subject;
        subject.registObserver(this);
    }
    
    @Override
    public void update(String msg) {
        System.out.println("observer1 得到 3D 号码 -->" + msg + ",我要记录下来");
    }
}
