package com.pojo;

import java.io.Serializable;

/**
 * @program: config_demo
 * @description: 用户实体类
 * @author: Su
 * @create: 2020-09-01 08:35
 **/
public class User implements Serializable {

    private static final long serialVersionUID = -5907804756642392168L;
    private String id;
    private String userName;
    private String password;

    public User(String id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
