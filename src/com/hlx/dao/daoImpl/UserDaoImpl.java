package com.hlx.dao.daoImpl;

import com.hlx.dao.UserDao;
import com.hlx.entity.User;

import java.sql.SQLException;

/**
 * @author hlx
 * @create 2020-08-05 18:27
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryUserByUsername(String uname) {
        String sql = "select uname,upwd from user where uname=?";
        return queryForOne(User.class, sql, uname);
    }

    @Override
    public User queryUserByUsernameAndPassword(String uname, String upwd) {
        String sql = "select uid, uname,upwd from user where uname=? and upwd=?";
        return queryForOne(User.class, sql, uname, upwd);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into user(uname,upwd,email) values(?,?,?)";

        return update(sql, user.getUname(), user.getUpwd(),user.getEmail());

    }
}
