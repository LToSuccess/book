package com.hlx.test;

import com.hlx.dao.UserDao;
import com.hlx.dao.daoImpl.UserDaoImpl;
import com.hlx.entity.User;
import org.junit.Test;

/**
 * @author hlx
 * @create 2020-08-05 19:00
 */
public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        if (userDao.queryUserByUsername("aa") == null) {
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名不可用！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDao.queryUserByUsernameAndPassword("aa", "aa") == null) {
            System.out.println("用户名或密码错误，登录失败");
        } else {
            System.out.println("查询成功");
        }
    }

   /* @Test
    public void saveUser() {
        int i = userDao.saveUser(new User("mn", "as"));
        System.out.println(i);
    }*/
}
