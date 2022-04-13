package com.mgx.bookshandler.web.customException;
@SuppressWarnings("serial")
public class CollectionBooksException extends RuntimeException {
    public CollectionBooksException(String message) {
        super(message);
    }
}
