package com.mgx.bookshandler.service;

import com.mgx.bookshandler.entities.CollectionBooks;

import java.util.Collection;


public interface CollectionBooksService {

    Collection<CollectionBooks> findAll();

    public CollectionBooks findOne(Long id);
    public CollectionBooks findByName(String name);

    void save(CollectionBooks collectionBooks);

    void update(CollectionBooks collectionBooks);

    void delete(CollectionBooks id);
}
