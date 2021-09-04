package com.example.springboot;

import com.example.springboot.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoDemo {
    public static void main(String[] args) {
        ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao res = (UserDao) application.getBean("userDao");
        res.save();
    }
}
