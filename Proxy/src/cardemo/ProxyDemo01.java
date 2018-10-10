package cardemo;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 增强Qq车的速度，刹车调用之前的逻辑
 */
public class ProxyDemo01 {
    @Test
    public void fun01(){
        Qq qq = new Qq();
        Car proxyCar = (Car) Proxy.newProxyInstance(qq.getClass().getClassLoader(), qq.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //只增强速度
                if ("run".equals(method.getName())) {
                    System.out.println("5s破百！！！");
                    return null;
                }
                //刹车调用之前的逻辑
                return method.invoke(qq, args);
            }
        });

        proxyCar.run();
        proxyCar.stop();
        String s = proxyCar.addOil(93);
        System.out.println(s);
    }
}
