package com.hlx.service.serviceImpl;

import com.hlx.dao.BookDao;
import com.hlx.dao.OrderDao;
import com.hlx.dao.OrderDaoItem;
import com.hlx.dao.daoImpl.BookDaoImpl;
import com.hlx.dao.daoImpl.OrderDaoImpl;
import com.hlx.dao.daoImpl.OrderItemDaoImpl;
import com.hlx.entity.*;
import com.hlx.service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * @author hlx
 * @create 2020-08-12 15:54
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderDaoItem orderDaoItem = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        orderDao.saveOrder(order);
        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            orderDaoItem.saveOrderItem(orderItem);
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            bookDao.updateBook(book);
        }
        cart.clear();
        return orderId;
    }
}
