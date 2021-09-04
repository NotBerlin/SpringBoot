package com.example.springboot.factory;

import com.example.springboot.dao.UserDao;
import com.example.springboot.impl.UserDaoImpl;

public class StaticFactory {
    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
