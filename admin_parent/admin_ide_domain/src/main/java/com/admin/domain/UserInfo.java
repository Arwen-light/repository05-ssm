package com.admin.domain;

import java.util.List;

public class UserInfo {
    //  id       VARCHAR2(32) default SYS_GUID() not null,
    //  email    VARCHAR2(50) not null,
    //  username VARCHAR2(50),
    //  password VARCHAR2(50),
    //  phonenum VARCHAR2(20),
    //  status   INTEGER
    private String id;
    private String email;
    private String username;
    private String password;
    private String phoneNum;
    private Integer status;
    private String statusStr;
    private List<Role> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusStr() {

        if (status !=null){
            if(status == 0){
                statusStr = "关闭";
            };
            if(status == 1){
                statusStr = "开启";
            };
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
