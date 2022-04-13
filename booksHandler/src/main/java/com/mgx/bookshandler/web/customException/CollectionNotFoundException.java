package com.mgx.bookshandler.web.customException;
@SuppressWarnings("serial")
public class CollectionNotFoundException extends RuntimeException {


    private long id;

    public CollectionNotFoundException(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
