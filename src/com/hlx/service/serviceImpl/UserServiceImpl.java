package com.hlx.service.serviceImpl;

import com.hlx.dao.UserDao;
import com.hlx.dao.daoImpl.UserDaoImpl;
import com.hlx.entity.User;
import com.hlx.service.UserService;

/**
 * @author hlx
 * @create 2020-08-05 19:28
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        User user1 = userDao.queryUserByUsernameAndPassword(user.getUname(), user.getUpwd());
        return user1;
    }

    @Override
    public boolean existsUsername(String uname) {
        if (userDao.queryUserByUsername(uname) == null) {
            return false;
        }
        return true;
    }
}
