package com.hlx.service.serviceImpl;

import com.hlx.dao.BookDao;
import com.hlx.dao.daoImpl.BookDaoImpl;
import com.hlx.entity.Book;
import com.hlx.entity.Page;
import com.hlx.service.BookService;

import java.util.List;

/**
 * @author hlx
 * @create 2020-08-08 13:42
 */
public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<Book>();
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        int begin = (page.getPageNo() - 1) * pageSize;
        List<Book> items = bookDao.queryForItems(begin, pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<Book>();
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min, max);
        page.setPageTotalCount(pageTotalCount);
        page.setPageSize(pageSize);
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);
        int begin = (pageNo - 1) * pageSize;
        List<Book> items = bookDao.queryForItemsByprice(begin, pageSize,min,max);
        page.setItems(items);
        return page;
    }
}
