package com.hlx.dao.daoImpl;

import com.hlx.dao.OrderDao;
import com.hlx.entity.Order;

/**
 * @author hlx
 * @create 2020-08-12 15:35
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(order_id,create_time,price,status,user_id) values(?,?,?,?,?)";
        return update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }

}
