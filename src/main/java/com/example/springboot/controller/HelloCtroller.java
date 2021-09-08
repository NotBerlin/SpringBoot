package com.example.springboot.controller;

import com.example.springboot.dao.Data;
import com.example.springboot.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
@RequestMapping("/hello")
public class HelloCtroller {

    @GetMapping(value = "/test")
    public Data test(HttpServletRequest reqest,
                     String userName) throws JsonProcessingException {
//        Object data = new Object();
        // 创建map对象
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("weather", "晴朗");
        data.put("color", "黄色");

        // 使用entity对象
        User user = new User();
        user.setUserName("张三");
        user.setAge(18);

        // 将对象转json字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(user);

        Data result = new Data("操作成功",s , 0);
        return result;
    }
}
