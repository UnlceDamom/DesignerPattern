package casedemo;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 增强身高
 */
public class ProxyTest {
    @Test
    public void fun01(){
        Xiaoming xm = new Xiaoming();
        PersonInfo proxyXm = (PersonInfo) Proxy.newProxyInstance(xm.getClass().getClassLoader(), xm.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //只增强身高
                if ("height".equals(method.getName())) {
                    System.out.println("小明身高180cm");
                    return null;
                }
                method.invoke(xm, args);
                return null;
            }
        });
        proxyXm.height();
        proxyXm.name();
        proxyXm.age();
        proxyXm.job();

    }
}
