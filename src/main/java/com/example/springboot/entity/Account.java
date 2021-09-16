package com.example.springboot.entity;

public class Account {
    private String userName;
    private String userHeight;
    private String userWeight;
    private String userLooks;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserHeight() {
        return userHeight;
    }

    public void setUserHeight(String userHeight) {
        this.userHeight = userHeight;
    }

    public String getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(String userWeight) {
        this.userWeight = userWeight;
    }

    public String getUserLooks() {
        return userLooks;
    }

    public void setUserLooks(String userLooks) {
        this.userLooks = userLooks;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userName='" + userName + '\'' +
                ", userHeight='" + userHeight + '\'' +
                ", userWeight='" + userWeight + '\'' +
                ", userLooks='" + userLooks + '\'' +
                '}';
    }
}
