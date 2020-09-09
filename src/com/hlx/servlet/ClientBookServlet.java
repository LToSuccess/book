package com.hlx.servlet;

import com.hlx.entity.Book;
import com.hlx.entity.Page;
import com.hlx.service.BookService;
import com.hlx.service.serviceImpl.BookServiceImpl;
import com.hlx.utils.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hlx
 * @create 2020-08-10 9:21
 */
public class ClientBookServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtil.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtil.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("client/bookServlet?way=page");
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtil.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtil.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtil.parseInt(req.getParameter("min"), 0);
        int max = WebUtil.parseInt(req.getParameter("max"), Integer.MAX_VALUE);
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);
        StringBuilder sb = new StringBuilder("client/bookServlet?way=pageByPrice");
        if (req.getParameter("min") != null) {
            sb.append("&min=").append(req.getParameter("min"));
        }
        if (req.getParameter("max") != null) {
            sb.append("&max=").append(req.getParameter("max"));
        }
        page.setUrl(sb.toString());
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}
