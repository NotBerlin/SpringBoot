package com.example.springboot.entity;

public class Power {
    private String keyId;
    private String roleCode;
    private String routerPath;
    private String parentCode;
    private String powerCode;
    private String powerName;

    public String getKeyID() {
        return keyId;
    }

    public void setKeyID(String keyID) {
        this.keyId = keyID;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRouterPath() {
        return routerPath;
    }

    public void setRouterPath(String routerPath) {
        this.routerPath = routerPath;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getPowerCode() {
        return powerCode;
    }

    public void setPowerCode(String powerCode) {
        this.powerCode = powerCode;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    @Override
    public String toString() {
        return "Power{" +
                "keyID='" + keyId + '\'' +
                ", roleCode='" + roleCode + '\'' +
                ", routerPath='" + routerPath + '\'' +
                ", parentCode='" + parentCode + '\'' +
                ", powerCode='" + powerCode + '\'' +
                ", powerName='" + powerName + '\'' +
                '}';
    }
}
