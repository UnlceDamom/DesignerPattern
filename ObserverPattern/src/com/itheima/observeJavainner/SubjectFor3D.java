package com.itheima.observeJavainner;

import java.util.Observable;

/**
 * 3D彩票服务号
 */
public class SubjectFor3D extends Observable {
    private String msg;
    public String getMsg(){
        return msg;
    }
    
    /**
     * 主题更新消息
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
        setChanged();//用来设置一个内部标志位注明数据发生了变化
        notifyObservers();
    }
}
