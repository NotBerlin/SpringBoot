package com.example.springboot.impl;

import com.example.springboot.dao.UserDao;
import com.example.springboot.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {
    private UserDao res;

    //第一种，使用set方法注入
//    public void setRes(UserDao res) {
//        this.res = res;
//    }

    // 第二种，使用有参构造函数注入
    public UserServiceImpl(UserDao res) {
        this.res = res;
    }

    public UserServiceImpl() {}

    @Override
    public void save() {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserDao res = (UserDao) app.getBean("userDao");
        res.save();
    }
}
