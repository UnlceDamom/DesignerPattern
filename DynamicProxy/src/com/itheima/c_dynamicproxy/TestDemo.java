package com.itheima.c_dynamicproxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class TestDemo {

    @Test
    //使用动态代理增强run()方法, stop()不增强就调用之前的逻辑
    public void fun01(){
        final Qq qq = new Qq();

        //1. 通过jdk动态代理技术 生成增强(代理)对象
        //返回值就是增强(代理)对象
        //第一个参数: 类加载器
        //第二个参数: 被代理类实现接口的Class;  new Class[]{Car.class, }
        //第三个参数: 处理器;
        Car proxyCar = (Car) Proxy.newProxyInstance(qq.getClass().getClassLoader(), qq.getClass().getInterfaces() , new InvocationHandler() {
            @Override
            //也就是增强(代理)对象的方法全部由处理器来控制了 (方法调用一次, invoke执行一次)
            //参数1: 就是代理对象(慎用)
            //参数2: 当前执行的方法的Method对象
            //参数3: 当前方法的参数
            //返回值:当前方法执行的返回值
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                if("run".equals(method.getName())){
                    //增强run
                    System.out.println("5s破百...");
                    return null;
                }

                System.out.println(Arrays.toString(args));

                //对于其他的方法, 调用之前的逻辑
                //Object value = method.invoke(qq, args);
                //return value;
                return method.invoke(qq, args);
            }
        });

        //2. 调用
        proxyCar.run();
        //proxyCar.stop();
        //String addOil = proxyCar.addOil(95);
        //System.out.println("addOil="+addOil);

    }


}
