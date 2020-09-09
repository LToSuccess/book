package com.hlx.dao.daoImpl;

import com.hlx.dao.OrderDaoItem;
import com.hlx.entity.OrderItem;

/**
 * @author hlx
 * @create 2020-08-12 15:40
 */
public class OrderItemDaoImpl extends BaseDao implements OrderDaoItem {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(name,count,price,total_price,order_id) values(?,?,?,?,?)";
        return update(sql, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }
}
