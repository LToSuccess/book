package com.hlx.service;

import com.hlx.entity.User;

/**
 * @author hlx
 * @create 2020-08-05 19:28
 */
public interface UserService {
    public void registUser(User user);
    public User login(User user);
    public boolean existsUsername(String uname);

}
