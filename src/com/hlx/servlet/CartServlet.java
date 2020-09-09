package com.hlx.servlet;

import com.hlx.entity.Book;
import com.hlx.entity.Cart;
import com.hlx.entity.CartItem;
import com.hlx.service.BookService;
import com.hlx.service.serviceImpl.BookServiceImpl;
import com.hlx.utils.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hlx
 * @create 2020-08-12 8:44
 */
@WebServlet("/cartServlet")
public class CartServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtil.parseInt(req.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        System.out.println(cart);
        System.out.println(req.getHeader("referer"));
        req.getSession().setAttribute("lastName",cartItem.getName());
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtil.parseInt(req.getParameter("id"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.deleteItem(id);
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clear();
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtil.parseInt(req.getParameter("id"), 0);
        int count = WebUtil.parseInt(req.getParameter("count"), 1);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.updateCount(id, count);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
}
