package com.hlx.entity;

/**
 * @author hlx
 * @create 2020-08-04 10:57
 */
public class User {
    Integer uid;
    String uname;
    String upwd;
    String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public User(String uname, String upwd, String email) {
        this.uname = uname;
        this.upwd = upwd;
        this.email = email;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public User(Integer uid, String uname, String upwd, String email) {
        this.uid = uid;
        this.uname = uname;
        this.upwd = upwd;
        this.email = email;
    }

    public User() {
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
