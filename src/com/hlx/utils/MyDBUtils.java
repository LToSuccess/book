package com.hlx.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author hlx
 * @create 2020-08-05 18:02
 */
public class MyDBUtils {
    private static DataSource source;
    static {
        try {
            Properties properties = new Properties();
            InputStream is = MyDBUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            source = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection()  {
        Connection connection = null;
        try {
            connection = source.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(Connection connection) {
        DbUtils.closeQuietly(connection);
    }
}
