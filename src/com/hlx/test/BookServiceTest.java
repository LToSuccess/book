package com.hlx.test;

import com.hlx.entity.Book;
import com.hlx.service.BookService;
import com.hlx.service.serviceImpl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author hlx
 * @create 2020-08-08 13:45
 */
public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "红楼梦", "曹雪芹", new BigDecimal(9999), 88888, 78, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22, "红花楼", "曹雪芹", new BigDecimal(9999), 88888, 78, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void page(){
        System.out.println(bookService.page(1, 4));
    }
}