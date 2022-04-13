package com.mgx.bookshandler.utils.mock;

import com.mgx.bookshandler.web.model.BookApi;
import com.mgx.bookshandler.web.model.CollectionApi;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.TreeSet;

public class ApiTestCollectionMocks {
    public ApiTestCollectionMocks(){

    }
    public static CollectionApi collectionApi(){
        BookApi bookApi=new BookApi();

        bookApi.setAuthor("Test1");
        bookApi.setIsbn("isbn-12-12-12");
        bookApi.setTitle("Learn Kotlin From zero To Hero");
        bookApi.setCreationTimestamp(Timestamp.valueOf("2018-09-25 16:56:57.0"));
        bookApi.setUpdateTimestamp(Timestamp.valueOf("2018-09-25 16:56:57.0"));

        Collection<BookApi> bookApis=new TreeSet<>();
        bookApis.add(bookApi);

        CollectionApi collectionApi=new CollectionApi();
        collectionApi.setName("IT");
        collectionApi.setCreationTimestamp(Timestamp.valueOf("2018-09-25 16:56:57.0"));
        collectionApi.setUpdateTimestamp(Timestamp.valueOf("2018-09-25 16:56:57.0"));
        collectionApi.setBooksApi(bookApis);

        return collectionApi;
    }
    public static CollectionApi collectionApi2(){
        BookApi bookApi=new BookApi();

        bookApi.setAuthor("AAA");
        bookApi.setIsbn("isbn-11-11-11");
        bookApi.setTitle("Learn Python From zero To Hero");
        bookApi.setCreationTimestamp(new Date());
        bookApi.setUpdateTimestamp(new Date());

        Collection<BookApi> bookApis=new TreeSet<>();
        bookApis.add(bookApi);

        CollectionApi collectionApi=new CollectionApi();
        collectionApi.setName("IT");
        collectionApi.setCreationTimestamp(new Date());
        collectionApi.setUpdateTimestamp(new Date());
        collectionApi.setBooksApi(bookApis);

        return collectionApi;
    }
    public static CollectionApi collectionApi3(){

        CollectionApi collectionApi=new CollectionApi();
        collectionApi.setName("IT");
        collectionApi.setCreationTimestamp(new Date());
        collectionApi.setUpdateTimestamp(new Date());
        collectionApi.setBooksApi(null);

        return collectionApi;
    }
}
