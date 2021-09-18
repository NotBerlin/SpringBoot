package com.example.springboot.controller;

import com.example.springboot.dao.Data;
import com.example.springboot.entity.Account;
import com.example.springboot.entity.Power;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @GetMapping("/power")
    public Data getPower(String userID) {
        String sql = "\n" +
                "SELECT a.key_id, a.role_code, a.router_path, a.parent_code, a.power_code, a.power_name FROM user_table_power a INNER JOIN user_table_role b ON b.user_id = ? AND b.role_code = a.role_code";
        RowMapper<Power> rowMapper=new BeanPropertyRowMapper<Power>(Power.class);
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate");
        Data result;
        try {
            Power power = jdbcTemplate.queryForObject(sql, rowMapper, userID);
            System.out.println(power);
            result = new Data("操作成功",power , 0);
            return result;
        } catch(Exception e) {
            result = new Data("操作失败", null , 1);
            return result;
        }
    }
}
