package com.hlx.dao;

import com.hlx.entity.User;

/**
 * @author hlx
 * @create 2020-08-05 18:27
 */
public interface UserDao {

    public User queryUserByUsername(String uname);

    public User queryUserByUsernameAndPassword(String uname, String upwd);

    public int saveUser(User user);
}
