package com.mgx.bookshandler.web.customException;
@SuppressWarnings("serial")
public class CollectionBooksAlreadyExistException extends RuntimeException {
    public CollectionBooksAlreadyExistException(String message) {
        super(message);
    }
    private long name;

    public CollectionBooksAlreadyExistException(long name) {
        this.name = name;
    }

    public long getName() {
        return name;
    }

    public void setName(long name) {
        this.name = name;
    }
}
