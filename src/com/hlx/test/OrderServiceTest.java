package com.hlx.test;

import com.hlx.entity.Cart;
import com.hlx.entity.CartItem;
import com.hlx.service.OrderService;
import com.hlx.service.serviceImpl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author hlx
 * @create 2020-08-12 16:09
 */
public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(1, "C语言", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "python", 1, new BigDecimal(100), new BigDecimal(100)));
        OrderService orderService=new OrderServiceImpl();
        String order = orderService.createOrder(cart, 1);
        System.out.println(order);
    }
}