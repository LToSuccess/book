package com.hlx.servlet;

import com.hlx.entity.Cart;
import com.hlx.entity.User;
import com.hlx.service.OrderService;
import com.hlx.service.serviceImpl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hlx
 * @create 2020-08-12 16:13
 */
@WebServlet("/orderServlet")
public class OrderServlet extends BaseServlet {
    OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User user = (User) req.getSession().getAttribute("user");
        if (user==null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        Integer id = user.getUid();
        String orderId = orderService.createOrder(cart, id);
//        req.setAttribute("orderId", orderId);
//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);
        req.getSession().setAttribute("orderId",orderId);
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }
}
