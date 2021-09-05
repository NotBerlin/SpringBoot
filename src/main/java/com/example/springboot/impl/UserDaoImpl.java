package com.example.springboot.impl;

import com.example.springboot.dao.UserDao;
import com.example.springboot.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Properties;

@Component("userDao")
public class UserDaoImpl implements UserDao {

    private String userName;
    private int age;

    private List<String> strList;
    private Map<String, User> userMap;

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    private Properties properties;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserDaoImpl() {
        System.out.println("创建了UserDao");
    }

    public void init() {
        System.out.println("初始化方法");
    }

    public void destory() {
        System.out.println("销毁方法");
    }

    @Override
    public void save() {
//        System.out.println(userName + "====" + age);
        System.out.println(strList);
        System.out.println(userMap);
        System.out.println(properties);
        System.out.println("调用成功。。。");
    }
}
