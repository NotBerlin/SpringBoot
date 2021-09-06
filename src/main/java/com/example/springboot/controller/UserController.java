package com.example.springboot.controller;

import com.example.springboot.config.SpringCofiguration;
import com.example.springboot.impl.UserServiceImpl;
import com.example.springboot.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {
    public static void main(String[] args) {
//        使用注解配置xml配置
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringCofiguration.class);
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        如果容器中存在某个类型多个的情况，以下通过类型获取会报错
//        UserService userService = app.getBean(UserServiceImpl.class);
        UserService userService =(UserService) app.getBean("userService");
        userService.save();
    }
}
