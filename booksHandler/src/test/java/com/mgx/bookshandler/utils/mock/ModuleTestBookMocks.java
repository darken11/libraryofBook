package com.mgx.bookshandler.utils.mock;

import com.mgx.bookshandler.entities.Book;


import java.util.Date;

public class ModuleTestBookMocks {
    public ModuleTestBookMocks() {
    }

    public static Book book() {

        Book book = new Book();

        book.setTitle("Ninja2");
        book.setAuthor("Ninja");
        book.setIsbn("isbn-11-12-13");
        book.setCreationTimestamp(null);
        book.setUpdateTimestamp(null);
        return book;
    }
}
