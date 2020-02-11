package com.example.doggamore.models;

import java.util.Date;

public class User {

    int id;
    private String userName;
    private String password;
    private String email;
    private Date bdayDate;
    User(){

    }

    public User(String name){
        this.userName = name;
    }

    User(int id, String userName, String password, Date bdayDate, String email){
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.bdayDate = bdayDate;
        this.email = email;
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
