package com.mgx.bookshandler.web.controller;

import com.mgx.bookshandler.constants.ApiConstants;
import com.mgx.bookshandler.web.customException.BookNotFoundException;
import com.mgx.bookshandler.web.customException.CollectionBooksException;
import com.mgx.bookshandler.entities.Book;
import com.mgx.bookshandler.entities.CollectionBooks;
import com.mgx.bookshandler.service.BookService;
import com.mgx.bookshandler.service.CollectionBooksService;
import com.mgx.bookshandler.web.converter.BookApiConverter;
import com.mgx.bookshandler.web.customException.CollectionNotFoundException;
import com.mgx.bookshandler.web.model.BookApi;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.*;

@RestController
public class BookRestController {
    private final BookService bookService;
    private final CollectionBooksService collectionBooksService;
    private CollectionRestController collectionRestController;

    private final BookApiConverter bookApiConverter;

    public BookRestController(BookService bookRepository, CollectionBooksService collectionBooksService,
                              CollectionRestController collectionRestController, BookApiConverter bookApiConverter) {
        this.bookService = bookRepository;
        this.collectionBooksService = collectionBooksService;
        this.collectionRestController = collectionRestController;

        this.bookApiConverter = bookApiConverter;
    }

    /**
     * Get the List of Books
     *
     * @return
     */
    @GetMapping(path = "/books", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody

    public Collection<BookApi> bookList() {

        Collection<Book> bookList = bookService.findAll();
        Collection<BookApi> lst = new TreeSet<>();

        bookList.forEach(book -> {

            BookApi bcApis = bookApiConverter.getBookApiFromBook(book);


            lst.add(bcApis);


        });

        return lst;
    }

    /**
     * get Books By Id
     *
     * @param bookId
     * @return
     */
    @GetMapping(path = "/book/{bookId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public BookApi getBookById(@PathVariable Long bookId) {
        Book bookById = bookService.findOne(bookId);
        if (bookById == null) {
            throw new BookNotFoundException(bookId);
        }
        return bookApiConverter.getBookApiFromBook(bookById);

    }


    /**
     * Add new Book
     *
     * @param bookApi
     * @return
     */

    @PostMapping("/books")
    public void createBook(@Valid @RequestBody BookApi bookApi) {

        CollectionBooks collectionBook = collectionBooksService.findOne(bookApi.getIdCollection());
        if (collectionBook == null) throw new CollectionBooksException(ApiConstants.collectionBookNotFound);

        Book book = bookApiConverter.getBookEntityFromBookApi(bookApi);
        book.setCollectionBooks(collectionBook);

        bookService.save(book);

    }

    /**
     * @param id
     */
    @DeleteMapping(path = "/book/{id}")
    public void delete(@PathVariable Long id) throws BookNotFoundException {

        Book book = bookService.findOne(id);
        if (book == null) {
            throw new BookNotFoundException(id);
        }

        bookService.delete(book);
    }

    /**
     * @param bookApi
     * @return
     */
    @PutMapping("/book/{id}")
    public void updateBook(@PathVariable Long id, @RequestBody BookApi bookApi) throws BookNotFoundException {
        CollectionBooks collectionBook = collectionBooksService.findOne(bookApi.getIdCollection());

        if (collectionBook == null)
            throw new CollectionNotFoundException(bookApi.getIdCollection());
        bookApi.setIdBook(id);
        bookApi.setUpdateTimestamp(new Date());
        Book book1 = bookApiConverter.getBookEntityFromBookApi(bookApi);
        book1.setCollectionBooks(collectionBook);
        bookService.save(book1);
    }


}
