package com.hlx.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hlx
 * @create 2020-08-11 16:55
 */
public class Cart {
    //    private Integer totalCount;
//    private BigDecimal totalPrice;
    private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();


    /*功能方法开始*/
    public void addItem(CartItem cartItem) {
        CartItem cartItem1 = items.get(cartItem.getId());
        if (cartItem1 != null) {
            cartItem1.setCount(cartItem1.getCount() + 1);
            cartItem1.setTotalPrice(cartItem1.getPrice().multiply(new BigDecimal(cartItem1.getCount())));
        } else {
            items.put(cartItem.getId(), cartItem);
        }
    }

    public void deleteItem(Integer id) {
        items.remove(id);
    }

    public void clear() {
        items.clear();
    }

    public void updateCount(Integer id, Integer count) {
        CartItem cartItem = items.get(id);
        if (cartItem != null) {
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }
    }






    /*功能方法结束*/


    public Integer getTotalCount() {
        int totalCount = 0;
        for (CartItem value : items.values()) {
            totalCount += value.getCount();
        }
        return totalCount;
    }


    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (CartItem value : items.values()) {
            totalPrice = totalPrice.add(value.getPrice().multiply(new BigDecimal(value.getCount())));
        }
        return totalPrice;
    }


    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
