package com.hlx.test;

import com.hlx.dao.OrderDao;
import com.hlx.dao.daoImpl.OrderDaoImpl;
import com.hlx.entity.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;


/**
 * @author hlx
 * @create 2020-08-12 15:44
 */
public class OrderDaoTest {

    @Test
    public void saveOrder() {
        OrderDao order = new OrderDaoImpl();
        order.saveOrder(new Order("1234567890", new Date(), new BigDecimal(100), 0, 1));
    }
}