package com.itheima.c_dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.junit.Test;

interface Car{
    void run();

    void stop();

    String addOil(int num);
}
//被代理类
class Qq implements Car  {

    @Override
    public void run() {
        System.out.println("Qq 可以跑60迈...");
    }

    @Override
    public void stop() {
        System.out.println("Qq 可以刹车...");
    }

    @Override
    public String addOil(int num) {
        return "Qq车加"+num+"#油..";
    }
}
