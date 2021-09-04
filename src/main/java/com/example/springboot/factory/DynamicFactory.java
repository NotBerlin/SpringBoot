package com.example.springboot.factory;

import com.example.springboot.dao.UserDao;
import com.example.springboot.impl.UserDaoImpl;

public class DynamicFactory {
    public UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
