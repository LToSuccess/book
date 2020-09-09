package com.hlx.servlet;

import com.hlx.entity.Book;
import com.hlx.entity.Page;
import com.hlx.service.BookService;
import com.hlx.service.serviceImpl.BookServiceImpl;
import com.hlx.utils.WebUtil;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author hlx
 * @create 2020-08-08 13:55
 */
public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtil.parseInt(req.getParameter("pageNo"), 9999);
        pageNo+=1;
        /*String name = req.getParameter("name");
        String price = req.getParameter("price");
        String author = req.getParameter("author");
        String sales = req.getParameter("sales");
        String stock = req.getParameter("stock");*/
        Book book = WebUtil.copyParamToBean(req.getParameterMap(), new Book());
        bookService.addBook(book);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?way=page&pageNo="+pageNo);  //使用重定向
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        bookService.deleteBookById(Integer.parseInt(id));
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?way=page&pageNo="+req.getParameter("pageNo"));
    }

    public void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Book book = bookService.queryBookById(Integer.parseInt(id));
        req.setAttribute("book", book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtil.copyParamToBean(req.getParameterMap(), new Book());
        bookService.updateBook(book);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?way=page&pageNo="+req.getParameter("pageNo"));
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.queryBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtil.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtil.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("manager/bookServlet?way=page");
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }
}
