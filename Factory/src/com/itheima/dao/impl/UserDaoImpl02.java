package com.itheima.dao.impl;

import com.itheima.dao.UserDao;

public class UserDaoImpl02 implements UserDao {

    @Override
    public void save() {
        System.out.println("通过Hibernate操作数据库... save()");
    }

}
