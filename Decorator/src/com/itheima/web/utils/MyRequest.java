package com.itheima.web.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;

//增强类：得到被增强类的引用
public class MyRequest extends HttpServletRequestWrapper {
    //得到被增强类的引用
    private HttpServletRequest request;

    public MyRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    //增强getParameter方法
    
    @Override
    public String getParameter(String name) {
        //1.获得请求方法
        String methodStr = request.getMethod();
        //2.判断是get还是post
        if ("post".equalsIgnoreCase(methodStr)){
            try {
                request.setCharacterEncoding("utf-8");
                return request.getParameter(name);

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        }else if ("get".equalsIgnoreCase(methodStr)){
            //获得乱码
            String value = request.getParameter(name);
            //一编一解
            try {
                value = new String(value.getBytes("iso8859-1"),"utf-8");
                return value;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        }

        return super.getParameter(name);
    }
}
