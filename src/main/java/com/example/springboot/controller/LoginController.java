package com.example.springboot.controller;

import com.example.springboot.dao.Data;
import com.example.springboot.entity.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class LoginController {

    @PostMapping("/login")
    public Data login(@RequestBody Map<String, String> params){
        System.out.println(params.toString());
        String sql = "\n" +
                "SELECT a.user_name, b.user_height, b.user_weight, b.user_looks FROM user_table a INNER JOIN user_table_body b ON a.user_account = ? AND a.user_password = ? AND a.key_id = b.key_id";
        RowMapper<Account> rowMapper=new BeanPropertyRowMapper<Account>(Account.class);
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate");
        try {
            Account account = jdbcTemplate.queryForObject(sql, rowMapper, params.get("account"), params.get("password"));
            System.out.println(account);
            Data result = new Data("操作成功",account , 0);
            return result;
        } catch(Exception e) {
            Data result = new Data("操作失败", null , 1);
            return result;
        }
    }
}
