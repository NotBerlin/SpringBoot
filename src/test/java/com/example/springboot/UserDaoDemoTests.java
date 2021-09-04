package com.example.springboot;

import com.example.springboot.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoDemoTests {

    @Test
    // 测试scope属性
    public void test1() {
        ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao res1 = (UserDao) application.getBean("userDao");
//        UserDao res2 = (UserDao) application.getBean("userDao");
        System.out.println(res1);
        ((ClassPathXmlApplicationContext) application).close();
//        System.out.println(res2);
    }
}
