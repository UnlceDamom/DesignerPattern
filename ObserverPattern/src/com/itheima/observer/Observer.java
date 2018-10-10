package com.itheima.observer;

/**
 * 观察者接口：所有观察者都要实现这个接口
 * @author Damom
 */
public interface Observer {
    public void update(String msg);
}
