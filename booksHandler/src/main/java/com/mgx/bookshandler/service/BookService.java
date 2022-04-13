package com.mgx.bookshandler.service;

import com.mgx.bookshandler.entities.Book;

import java.util.Collection;
import java.util.List;

public interface BookService {
    Collection<Book> findAll();

    public Book findOne(Long id);

    void save(Book book);

    void update(Book book);

    void delete(Book id);

}
