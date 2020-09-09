package com.hlx.service;

import com.hlx.entity.Cart;

/**
 * @author hlx
 * @create 2020-08-12 15:53
 */
public interface OrderService {
    public String createOrder(Cart cart,Integer userId);
}
