package com.example.springboot.controller;

import com.example.springboot.dao.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloCtroller {

    @GetMapping("/test")
    public Data test(HttpServletRequest reqest){
//        Object data = new Object();
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("weather", "晴朗");
        data.put("color", "黄色");
        Data result = new Data("操作成功",data , 0);
        return result;
    }
}
