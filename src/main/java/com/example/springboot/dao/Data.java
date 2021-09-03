package com.example.springboot.dao;

import java.io.Serializable;
import java.util.Map;

public class Data<T> implements Serializable {
    private String msg;
    private Object data;
    private Number code;

    public Data(String msg, T data, Number code) {
        this.msg = msg;
        this.data = data;
        this.code = code;
    }

    public void setCode(Number code) {
        this.code = code;
    }

    public Number getCode() {
        return code;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}