package com.hlx.dao;

import com.hlx.entity.Book;

import java.util.List;

/**
 * @author hlx
 * @create 2020-08-08 13:06
 */
public interface BookDao {
    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForItemsByprice(int begin, int pageSize, int min, int max);
}
