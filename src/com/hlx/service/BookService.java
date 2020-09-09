package com.hlx.service;

import com.hlx.entity.Book;
import com.hlx.entity.Page;

import java.util.List;

/**
 * @author hlx
 * @create 2020-08-08 13:39
 */
public interface BookService {
    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
