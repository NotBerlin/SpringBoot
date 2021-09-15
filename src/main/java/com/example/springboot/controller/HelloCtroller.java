package com.example.springboot.controller;

import com.example.springboot.config.SpringCofiguration;
import com.example.springboot.dao.Data;
import com.example.springboot.entity.User;
import com.example.springboot.entity.VO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.PropertyVetoException;
import java.util.*;

@RestController
@RequestMapping("/hello")
public class HelloCtroller {

    @GetMapping(value = "/test")
    public Data test(HttpServletRequest reqest,
                     User user) throws JsonProcessingException {
//        Object data = new Object();
        // 创建map对象
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("weather", "晴朗");
        data.put("color", "黄色");

        // 使用entity对象
//        User user = new User();
//        user.setUserName(userName);
//        user.setAge(18);

        // 将对象转json字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(user);
        System.out.println(s);

        Data result = new Data("操作成功",s , 0);
        return result;
    }

    @GetMapping(value = "/test1")
    public Data test1(HttpServletRequest reqest,
                     String[] strs) throws JsonProcessingException {
        System.out.println(strs.toString());
        System.out.println(Arrays.asList(strs));
        Data result = new Data("操作成功",strs , 0);
        return result;
    }

    @PostMapping(value = "/test2")
    public Data test2(@RequestBody VO<User> vo) throws JsonProcessingException {
        System.out.println(vo.toString());
        Data result = new Data("操作成功",vo , 0);
        return result;
    }

    @PostMapping(value = "/test4")
    public Data test4(@RequestBody List<User> vo) throws JsonProcessingException {
        System.out.println(vo.toString());
        Data result = new Data("操作成功",vo , 0);
        return result;
    }

    @PostMapping(value = "/test5")
    public Data test5(@RequestBody List<User> vo) throws JsonProcessingException {
        System.out.println(vo.toString());
        Data result = new Data("操作成功",vo , 0);
        return result;
    }

    @GetMapping(value = "/test6")
    public Data test6(@RequestParam(value = "name", required = false, defaultValue = "zhangsan") String username) throws JsonProcessingException {
        System.out.println(username);
        Data result = new Data("操作成功",username , 0);
        return result;
    }

    @GetMapping(value = "/test7/{name}")
    public Data test7(@PathVariable(value = "name", required = false) String username) throws JsonProcessingException {
        System.out.println(username);
        Data result = new Data("操作成功",username , 0);
        return result;
    }

    @GetMapping(value = "/test8")
    public Data test8(String date) throws JsonProcessingException {
        System.out.println(date);
        Data result = new Data("操作成功",date , 0);
        return result;
    }

    @PostMapping(value = "/test9")
    public void test9(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
    }

    @GetMapping(value = "/test10")
    public void test10(@RequestHeader(value = "User-agent", required = true) String userAgent) {
        System.out.println(userAgent);
    }

    @PostMapping(value = "/database1")
    public Data database1(@RequestBody Map<String, Object> params) throws PropertyVetoException {
        System.out.println(params.toString());
        // 使用bean
//        ApplicationContext app = new AnnotationConfigApplicationContext(SpringCofiguration.class);
//        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate");
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://10.0.0.210:3306/studyDB?useSSL=false");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("root");
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
// 设置数据源
        jdbcTemplate.setDataSource(comboPooledDataSource);
 // 执行操作
        int row = jdbcTemplate.update("insert into account values(?, ?)", params.get("name"), params.get("money"));
        System.out.println(row);
        Data result = new Data("操作成功",params , 0);
        return result;
    }
}
