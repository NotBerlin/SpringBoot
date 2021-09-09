package com.example.springboot.controller;

import com.example.springboot.dao.Data;
import com.example.springboot.entity.User;
import com.example.springboot.entity.VO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

    @PostMapping(value = "/test3")
    public Data test3(@RequestBody VO<User> vo) throws JsonProcessingException {
        System.out.println(vo.toString());
        Data result = new Data("操作成功",vo , 0);
        return result;
    }
}
