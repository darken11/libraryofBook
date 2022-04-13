package com.mgx.bookshandler.web.converter;

import com.mgx.bookshandler.entities.Book;
import com.mgx.bookshandler.entities.CollectionBooks;
import com.mgx.bookshandler.web.model.BookApi;
import com.mgx.bookshandler.web.model.CollectionApi;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.TreeSet;
@Service
public class BookApiImplConverter implements BookApiConverter {

    public BookApiImplConverter() {
    }

    /**
     * Mapping BookApi to BookEntity
     *
     * @param collectionApi
     * @return
     */
    public CollectionBooks getCollectionBookEntityFromCollectionApi(CollectionApi collectionApi) {

        CollectionBooks collectionBooks = new CollectionBooks();

        collectionBooks.setName(collectionApi.getName());
        collectionBooks.setCreationTimestamp(collectionApi.getCreationTimestamp());
        collectionBooks.setUpdateTimestamp(collectionApi.getUpdateTimestamp());

        Collection<Book> lst = new TreeSet<>();

        if (collectionApi.getBooksApi() != null) {

            collectionApi.getBooksApi().forEach(book -> {
                Book bookModel = getBookEntityFromBookApi(book);
                lst.add(bookModel);

            });

            collectionBooks.setBooks(lst);
        }
        return collectionBooks;

    }

    /**
     * get Book from BookApi
     *
     * @param collectionBooks
     * @return
     */
    public CollectionApi getCollectionBookApiFromCollectionBook(CollectionBooks collectionBooks) {

        CollectionApi collectionApi = new CollectionApi();
        collectionApi.setName(collectionBooks.getName());
        collectionApi.setCreationTimestamp(collectionBooks.getCreationTimestamp());
        collectionApi.setUpdateTimestamp(collectionBooks.getUpdateTimestamp());
        Collection<BookApi> lst = new TreeSet<>();

        if (collectionBooks.getBooks() != null) {

            collectionBooks.getBooks().forEach(book -> {
                BookApi bcApis = getBookApiFromBook(book);
                lst.add(bcApis);

            });

            collectionApi.setBooksApi(lst);
        }

        return collectionApi;

    }

    public BookApi getBookApiFromBook(Book book) {

        BookApi bookApi = new BookApi();
        bookApi.setIsbn(book.getIsbn());
        bookApi.setIdBook(book.getIdBook());
        if (book.getCollectionBooks() != null) {
            bookApi.setIdCollection(book.getCollectionBooks().getIdCollectionBook());
        }
        bookApi.setTitle(book.getTitle());
        bookApi.setAuthor(book.getAuthor());
        bookApi.setCreationTimestamp(book.getCreationTimestamp());
        bookApi.setUpdateTimestamp(book.getUpdateTimestamp());
        return bookApi;

    }


    /**
     * Mapping BookApi to BookEntity
     *
     * @param bookApi
     * @return
     */
    public Book getBookEntityFromBookApi(BookApi bookApi) {

        Book book = new Book();
        book.setIdBook(bookApi.getIdBook());
        book.setIsbn(bookApi.getIsbn());
        book.setTitle(bookApi.getTitle());
        book.setAuthor(bookApi.getAuthor());
        if(book.getCollectionBooks()!=null){
            book.getCollectionBooks().setIdCollectionBook(bookApi.getIdCollection());
        }

        book.setCreationTimestamp(bookApi.getCreationTimestamp());
        book.setUpdateTimestamp(bookApi.getUpdateTimestamp());
        return book;

    }
}
