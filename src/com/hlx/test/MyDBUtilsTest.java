package com.hlx.test;

import com.hlx.utils.MyDBUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author hlx
 * @create 2020-08-05 18:21
 */
public class MyDBUtilsTest {
    @Test
    public void test() throws SQLException {
        Connection connection = MyDBUtils.getConnection();
        System.out.println(connection);
        MyDBUtils.close(connection);
    }
}
