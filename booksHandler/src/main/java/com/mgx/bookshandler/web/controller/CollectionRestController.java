package com.mgx.bookshandler.web.controller;

import com.mgx.bookshandler.constants.ApiConstants;
import com.mgx.bookshandler.entities.Book;
import com.mgx.bookshandler.web.customException.BookNotFoundException;
import com.mgx.bookshandler.web.customException.CollectionBooksAlreadyExistException;
import com.mgx.bookshandler.web.customException.CollectionBooksException;
import com.mgx.bookshandler.entities.CollectionBooks;
import com.mgx.bookshandler.service.BookService;
import com.mgx.bookshandler.service.CollectionBooksService;
import com.mgx.bookshandler.web.converter.BookApiConverter;


import com.mgx.bookshandler.web.customException.CollectionNotFoundException;
import com.mgx.bookshandler.web.model.CollectionApi;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import java.util.Date;
import java.util.TreeSet;

@RestController
public class CollectionRestController {
    private final BookService bookService;
    private final CollectionBooksService collectionBooksService;
    private final BookApiConverter bookApiConverter;

    public CollectionRestController(BookService bookService, CollectionBooksService collectionBooksService, BookApiConverter bookApiConverter) {
        this.bookService = bookService;
        this.collectionBooksService = collectionBooksService;
        this.bookApiConverter = bookApiConverter;
    }

    @GetMapping(path = "/collectionBooks", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Collection<CollectionApi> collectionList() {
        Collection<CollectionBooks> collections = collectionBooksService.findAll();
        Collection<CollectionApi> sortedCollections = new TreeSet<>();
        collections.forEach(collectionBooks -> {

            CollectionApi collectionApi = bookApiConverter.getCollectionBookApiFromCollectionBook(collectionBooks);
            sortedCollections.add(collectionApi);

        });

        return sortedCollections;

    }

    /**
     * get Collections Books By Id
     *
     * @param collectionId
     * @return
     */
    @GetMapping(path = "/collection/{collectionId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public CollectionApi getCollectionById(@PathVariable Long collectionId) {
        CollectionBooks collectionBooks = collectionBooksService.findOne(collectionId);
        if (collectionBooks == null) {
            throw new CollectionNotFoundException(collectionId);
        }

        return bookApiConverter.getCollectionBookApiFromCollectionBook(collectionBooks);

    }

    /**
     * Add new Collection Book
     *
     * @param
     * @return
     */
    @PostMapping("/collections")
    public void addCollection(@RequestBody CollectionApi collectionApi) throws CollectionBooksAlreadyExistException {
        CollectionBooks collectionBookName=collectionBooksService.findByName(collectionApi.getName());
        if(collectionBookName !=null){
            throw  new CollectionBooksAlreadyExistException(collectionApi.getName());
        }
        CollectionBooks collectionBooks = bookApiConverter.getCollectionBookEntityFromCollectionApi(collectionApi);

        collectionBooksService.save(collectionBooks);
    }

    /**
     * Delete Collection Book with Id
     *
     * @param id
     */
    @DeleteMapping(path = "/collection/{id}")
    public void deleteCollection(@PathVariable Long id) {
        if (id == null) {
            throw new CollectionBooksException(ApiConstants.notValidId + id);
        }
        CollectionBooks book = collectionBooksService.findOne(id);
        if (book == null) {
            throw new CollectionBooksException(ApiConstants.collectionNotFoundWithCurrentId + id);
        }

        collectionBooksService.delete(book);
    }

    /**
     * @param id
     * @param collectionBooksApi
     * @return
     */
    @PutMapping("/collection/{id}")
    public void updateCollection(@PathVariable Long id, @RequestBody CollectionApi collectionBooksApi) {
        CollectionBooks collectionBook = collectionBooksService.findOne(id);
        if (collectionBook == null) {
            throw new CollectionNotFoundException(id);
        }
        collectionBook = bookApiConverter.getCollectionBookEntityFromCollectionApi(collectionBooksApi);
        collectionBook.setIdCollectionBook(id);
        collectionBook.setUpdateTimestamp(new Date());

        collectionBooksService.update(collectionBook);
    }


}
