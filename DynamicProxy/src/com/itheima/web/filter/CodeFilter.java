package com.itheima.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CodeFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("进入过滤器");
        //1.强转两个参数
        //当前的request其实就是被增强的对象，需要一个增强对象(需要通过增强的类来创建出来)，
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //2.增强HttpServletRequest的getParameter()方法，其他的方法不需要
        //参数1:ClassLoader loader 代理对象的类加载器 一般使用被代理对象的类加载器
        //参数2:Class<?>[] interfaces(不要写死) 代理对象的要实现的接口 一般使用的被代理对象实现的接口
        //参数3:InvocationHandler h (接口)执行处理类
        HttpServletRequest myRequest = (HttpServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
            //参数3.1:代理对象(慎用)
            //参数3.2:当前执行的方法
            //参数3.3:当前执行的方法运行时传递过来的参数
            //返回值:当前方法执行的返回值
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //增强的是getParameter方法
                if ("getParameter".equals(method.getName())){
                    String methodStr = request.getMethod();
                    //是post还是get
                    if ("post".equalsIgnoreCase(methodStr)){
                        request.setCharacterEncoding("utf-8");
                        return method.invoke(request,args);

                    }else if ("get".equalsIgnoreCase(methodStr)){
                        String value = (String) method.invoke(request, args);
                        value = new String(value.getBytes("iso8859-1"),"utf-8");
                        return value;
                    }
                }
                
                return method.invoke(request,args);
            }
        });


        chain.doFilter(myRequest, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
