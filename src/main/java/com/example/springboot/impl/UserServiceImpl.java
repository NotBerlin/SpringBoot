package com.example.springboot.impl;

import com.example.springboot.dao.UserDao;
import com.example.springboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

// 这一种是使用xml配置，下面是使用注解进行配置
//public class UserServiceImpl implements UserService {
//    private UserDao res;
//
//    //第一种，使用set方法注入
////    public void setRes(UserDao res) {
////        this.res = res;
////    }
//
//    // 第二种，使用有参构造函数注入
//    public UserServiceImpl(UserDao res) {
//        this.res = res;
//    }
//
//    public UserServiceImpl() {}
//
//    @Override
//    public void save() {
////        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
////        UserDao res = (UserDao) app.getBean("userDao");
//        res.save();
//    }
//}


// 这个方法是使用注解的方式进行配置
// Component将类以该名字作为id注入
//@Component("userService")
@Service("userService")
public class UserServiceImpl implements UserService{
    // 自动注入
    // Autowired按照数据类型从spring中匹配
//    @Autowired
    // 注入的类名
    // Qualifier按照id的值名称，从spring容器匹配
    // Qualifier必须结合Autowired使用
//    @Qualifier("userDao")
    // Resource注解可以代替（Qualifier+Autowired）
    @Resource(name = "userDao")
    private UserDao userDao;

    public UserServiceImpl(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public UserServiceImpl() {}
    @Override
    public void save() {
        System.out.println("使用注解的方式创建bean");
    }
}