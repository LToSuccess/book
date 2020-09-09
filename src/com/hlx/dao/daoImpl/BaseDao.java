package com.hlx.dao.daoImpl;

import com.hlx.utils.MyDBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author hlx
 * @create 2020-08-05 18:28
 */
public abstract class BaseDao {
    private QueryRunner runner = new QueryRunner();

    public int update(String sql, Object... args) {
        Connection connection = MyDBUtils.getConnection();
        try {
            return runner.update(connection, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            MyDBUtils.close(connection);
        }
        return -1;
    }

    public <T> T queryForOne(Class<T> clazz, String sql, Object... args) {
        Connection connection = null;
        try {
            connection = MyDBUtils.getConnection();
            T query = runner.query(connection, sql, new BeanHandler<T>(clazz), args);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyDBUtils.close(connection);
        }

        return null;
    }

    public <T> List<T> queryForList(Class<T> clazz, String sql, Object... args)  {
        Connection connection = MyDBUtils.getConnection();
        try {
            return runner.query(connection, sql, new BeanListHandler<T>(clazz), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyDBUtils.close(connection);
        }
        return null;
    }

    public Object queryForSingleValue(String sql, Object... args)  {
        Connection connection = MyDBUtils.getConnection();
        try {
            return runner.query(connection, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyDBUtils.close(connection);
        }
        return null;
    }
}
