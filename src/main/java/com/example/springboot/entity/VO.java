package com.example.springboot.entity;

import java.util.List;

public class VO<T> {
    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "VO{" +
                "list=" + list +
                '}';
    }
}
