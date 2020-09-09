package com.hlx.test;

import com.hlx.entity.Cart;
import com.hlx.entity.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author hlx
 * @create 2020-08-12 8:24
 */
public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(1, "C语言", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "python", 1, new BigDecimal(100), new BigDecimal(100)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(1, "C语言", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "python", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(1, "C语言", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "python", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(1, "C语言", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "python", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.updateCount(2, 3);
        System.out.println(cart);
    }
}