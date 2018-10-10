package com.itheima.observer;

/**
 * 主题接口：所有主题都要实现这个接口
 * @author Damom
 */
public interface Subject {
    /**
     * 注册一个观察者
     * @param observer
     */
    public void registObserver(Observer observer);

    /**
     * 移除一个观察者
     * @param observer
     */
    public void removeObserver(Observer observer);
    
    /**
     * 通知所有观察者
     */
    public void notifyObservers();
}
