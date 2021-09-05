package com.example.springboot.controller;

import java.sql.Connection;
import java.sql.SQLException;

public class DruidDataSource {
    public static void main(String[] args) throws SQLException {
        com.alibaba.druid.pool.DruidDataSource druidDataSource = new com.alibaba.druid.pool.DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/test");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("password");
        Connection connection = druidDataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
