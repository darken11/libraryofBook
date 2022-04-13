package com.mgx.bookshandler.utils.mock;

import com.mgx.bookshandler.entities.Book;
import com.mgx.bookshandler.entities.CollectionBooks;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.TreeSet;

public class ModuleTestCollectionMocks {
    public ModuleTestCollectionMocks(){

    }
    public static CollectionBooks collectionBooks(){
        CollectionBooks collectionBooks=new CollectionBooks();
        Book book=new Book();

        book.setAuthor("Test1");
        book.setTitle("Learn Kotlin From zero To Hero");
        book.setIsbn("isbn-12-12-12");
        book.setCreationTimestamp(Timestamp.valueOf("2018-09-25 16:56:57.0"));
        book.setUpdateTimestamp(Timestamp.valueOf("2018-09-25 16:56:57.0"));

        Collection<Book> bookCollection=new TreeSet<>();
        bookCollection.add(book);

        collectionBooks.setName("IT");
        collectionBooks.setCreationTimestamp(Timestamp.valueOf("2018-09-25 16:56:57.0"));
        collectionBooks.setUpdateTimestamp(Timestamp.valueOf("2018-09-25 16:56:57.0"));
        collectionBooks.setBooks(bookCollection);

        return collectionBooks;

    }
    public static CollectionBooks collectionBooks2(){
        CollectionBooks collectionBooks=new CollectionBooks();
        Book book=new Book();

        book.setAuthor("Test2");
        book.setTitle("Travel to The Sky");
        book.setIsbn("isbn-12-12-13");
        book.setCreationTimestamp(new Date());
        book.setUpdateTimestamp(new Date());

        Collection<Book> bookCollection=new TreeSet<>();
        bookCollection.add(book);

        collectionBooks.setName("Travel");
        collectionBooks.setCreationTimestamp(new Date());
        collectionBooks.setUpdateTimestamp(new Date());
        collectionBooks.setBooks(bookCollection);

        return collectionBooks;

    }
    public static CollectionBooks collectionBooks3(){
        CollectionBooks collectionBooks=new CollectionBooks();


        collectionBooks.setName("Travel");
        collectionBooks.setCreationTimestamp(new Date());
        collectionBooks.setUpdateTimestamp(new Date());
        collectionBooks.setBooks(null);

        return collectionBooks;

    }
}
