package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import com.itheima.utils.BeanFactory;

public class UserServiceImpl implements UserService {
    @Override
    public void regist() {
        System.out.println("UserService...regist()");
        UserDao userDao = (UserDao) BeanFactory.getBean("userDao");
        userDao.save();
    }
}
