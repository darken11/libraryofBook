package com.mgx.bookshandler.utils.mock;

import com.mgx.bookshandler.web.model.BookApi;

import java.util.Date;

public class ApiTestBookMocks {
    public ApiTestBookMocks() {
    }

    public static BookApi bookApi(){
        BookApi bookApi=new BookApi();
        bookApi.setTitle("Ninja2");
        bookApi.setIsbn("isbn-11-12-13");
        bookApi.setAuthor("Ninja");
        bookApi.setCreationTimestamp(null);
        bookApi.setUpdateTimestamp(null);
        return bookApi;
    }
    public static BookApi bookApi2(){
        BookApi bookApi=new BookApi();
        bookApi.setTitle("JAVA8");
        bookApi.setIsbn("isbn-11-9-13");
        bookApi.setAuthor("Rolf");
        bookApi.setCreationTimestamp(new Date());
        bookApi.setUpdateTimestamp(new Date());
        return bookApi;
    }
}
