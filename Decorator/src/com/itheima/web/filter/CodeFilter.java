package com.itheima.web.filter;

import com.itheima.web.utils.MyRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CodeFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("进入过滤器");

        //强转两个参数
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        MyRequest myRequest = new MyRequest(request);

        chain.doFilter(myRequest, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
