package com.dao;

import com.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDAO {
    int insert(Book book);
    int delete(int id);
    int update(Book book);
    List<Book> view();
    Book view(int id);
    List<Book> view(String name);
}