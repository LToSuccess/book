package com.hlx.dao;

import com.hlx.entity.Order;

/**
 * @author hlx
 * @create 2020-08-12 15:33
 */
public interface OrderDao {
    public int saveOrder(Order order);
}
