package com.mgx.bookshandler.service;


import com.mgx.bookshandler.constants.ApiConstants;
import com.mgx.bookshandler.entities.Book;
import com.mgx.bookshandler.entities.CollectionBooks;
import com.mgx.bookshandler.repositories.BookRepository;
import com.mgx.bookshandler.repositories.CollectionBookRepository;
import com.mgx.bookshandler.web.customException.BookNotFoundException;
import com.mgx.bookshandler.web.customException.CollectionBooksException;
import com.mgx.bookshandler.web.customException.CollectionNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Date;

@Service
@Transactional
public class CollectionBooksServiceImpl implements CollectionBooksService {

    private final CollectionBookRepository collectionBookRepository;
    private final BookRepository bookRepository;

    public CollectionBooksServiceImpl(CollectionBookRepository collectionBookRepository, BookRepository bookRepository) {
        this.collectionBookRepository = collectionBookRepository;
        this.bookRepository = bookRepository;

    }

    @Override
    public Collection<CollectionBooks> findAll() throws CollectionNotFoundException{
        Collection <CollectionBooks>collectionBook=collectionBookRepository.findAll();
        Collection <Book> lstBk=bookRepository.findAll();
        if(!CollectionUtils.isEmpty(lstBk)){
            collectionBook.iterator().next().setBooks(lstBk);
        }


        return collectionBook;
    }

    @Override
    public CollectionBooks findOne(Long id) throws CollectionNotFoundException{


        return collectionBookRepository.findById(id).orElse(null);
    }

    @Override
    public CollectionBooks findByName(String name) {
        return collectionBookRepository.findCollectionByName(name);
    }


    @Override
    public void save(CollectionBooks collectionBooks) throws CollectionNotFoundException{


        CollectionBooks collectionBooksLst= collectionBookRepository.save(collectionBooks);
        if (collectionBooks.getBooks() != null) {
            collectionBooks.getBooks().forEach(book -> {
                book.setCollectionBooks(collectionBooksLst);
               bookRepository.save(book);
            });
        }

         ResponseEntity.status(200);
    }

    @Override
    public void update(CollectionBooks collectionBooks) throws CollectionBooksException {
        collectionBookRepository.save(collectionBooks);
    }

    @Override
    public void delete(CollectionBooks id) throws CollectionNotFoundException{
        collectionBookRepository.delete(id);
    }
}
