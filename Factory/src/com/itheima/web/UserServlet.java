package com.itheima.web;

import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import com.itheima.utils.BeanFactory;
import org.junit.Test;

//对象的使用者不是创建者
public class UserServlet {
    @Test
    public void doGet(){
        UserService userService = (UserService) BeanFactory.getBean("userService");
        userService.regist();
    }
}
