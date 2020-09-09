package com.hlx.test;

import com.hlx.dao.OrderDaoItem;
import com.hlx.dao.daoImpl.OrderItemDaoImpl;
import com.hlx.entity.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author hlx
 * @create 2020-08-12 15:47
 */
public class OrderDaoItemTest {

    @Test
    public void saveOrderItem() {
        OrderDaoItem orderItem = new OrderItemDaoImpl();
        orderItem.saveOrderItem(new OrderItem(null, "java从入门到精通", 1, new BigDecimal(100), new BigDecimal(100), "1234567890"));
        orderItem.saveOrderItem(new OrderItem(null, "java从入门", 2, new BigDecimal(100), new BigDecimal(100), "1234567890"));

    }
}