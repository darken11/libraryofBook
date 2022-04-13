package com.mgx.bookshandler.service;

import com.mgx.bookshandler.constants.ApiConstants;
import com.mgx.bookshandler.entities.Book;
import com.mgx.bookshandler.repositories.BookRepository;
import com.mgx.bookshandler.web.customException.BookNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;


@Service
@Transactional
public class BookServiceImpl implements BookService {


    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository1) {
        this.bookRepository = bookRepository1;
    }

    @Override
    public List<Book> findAll() throws BookNotFoundException {
        return bookRepository.findAll();
    }

    @Override
    public Book findOne(Long id) throws BookNotFoundException {


        return bookRepository.findById(id).orElse(null);
    }


    @Override
    public void save(Book book) throws BookNotFoundException{
         bookRepository.save(book);
    }

    @Override
    public void update(Book book) throws BookNotFoundException {
        Book bookToUpdate = bookRepository.findById(book.getIdBook()).orElse(null);
        if (bookToUpdate == null) throw new BookNotFoundException(book.getIdBook());
         bookRepository.save(bookToUpdate);
    }

    @Override
    public void delete(Book id) throws BookNotFoundException {
        bookRepository.delete(id);

    }

}
