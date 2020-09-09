package com.hlx.test;

import com.hlx.dao.BookDao;
import com.hlx.dao.daoImpl.BookDaoImpl;
import com.hlx.entity.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author hlx
 * @create 2020-08-08 13:27
 */
public class BookDaoTest {
    BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "三国演义", "罗贯中", new BigDecimal(9999), 45000, 0, null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21, "西游记", "吴承恩", new BigDecimal(9999), 45000, 0, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookDao.queryBooks()) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForItems() {
        for (Book queryForItem : bookDao.queryForItems(8, 4)) {
            System.out.println(queryForItem);
        }
    }

    @Test
    public void queryForPageTotalCountByprice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(10, 8888));
    }

    @Test
    public void queryForItemsByPrice() {
        for (Book queryForItem : bookDao.queryForItemsByprice(0, 4, 10, 9999)) {
            System.out.println(queryForItem);
        }
    }
}