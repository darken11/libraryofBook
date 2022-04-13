package com.mgx.bookshandler.web.converter;

import com.mgx.bookshandler.entities.Book;
import com.mgx.bookshandler.entities.CollectionBooks;
import com.mgx.bookshandler.web.model.BookApi;
import com.mgx.bookshandler.web.model.CollectionApi;

public interface BookApiConverter {


    CollectionBooks getCollectionBookEntityFromCollectionApi(CollectionApi collectionApi);

    CollectionApi getCollectionBookApiFromCollectionBook(CollectionBooks collectionBooks);

    BookApi getBookApiFromBook(Book book);

    Book getBookEntityFromBookApi(BookApi bookApi);
}
