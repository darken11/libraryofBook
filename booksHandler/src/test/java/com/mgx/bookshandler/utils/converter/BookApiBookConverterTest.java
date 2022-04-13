package com.mgx.bookshandler.utils.converter;


import com.mgx.bookshandler.entities.Book;

import com.mgx.bookshandler.entities.CollectionBooks;
import com.mgx.bookshandler.utils.configuration.TestApplicationConfig;
import com.mgx.bookshandler.utils.mock.ApiTestBookMocks;
import com.mgx.bookshandler.utils.mock.ApiTestCollectionMocks;
import com.mgx.bookshandler.utils.mock.ModuleTestBookMocks;

import com.mgx.bookshandler.utils.mock.ModuleTestCollectionMocks;
import com.mgx.bookshandler.web.converter.BookApiConverter;
import com.mgx.bookshandler.web.model.BookApi;
import com.mgx.bookshandler.web.model.CollectionApi;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@ContextConfiguration(classes={TestApplicationConfig.class})
@RunWith(SpringRunner.class)
public class BookApiBookConverterTest {

    @Autowired
    private BookApiConverter bookApiConverter;

    @Test
    public void convertFromBookTest() {
        Book book =  bookApiConverter.getBookEntityFromBookApi(ApiTestBookMocks.bookApi());
        Assert.assertEquals(ModuleTestBookMocks.book(), book);
    }

    @Test
    public void convertToBookTest() {
        BookApi bookApi =  bookApiConverter.getBookApiFromBook(ModuleTestBookMocks.book());
        Assert.assertEquals(ApiTestBookMocks.bookApi(), bookApi);
    }
    @Test
    public void convertFromCollectionTest() {
        CollectionBooks collectionBooks =  bookApiConverter.getCollectionBookEntityFromCollectionApi(ApiTestCollectionMocks.collectionApi());
        Assert.assertEquals(ModuleTestCollectionMocks.collectionBooks(), collectionBooks);
    }
    @Test
    public void convertToCollectionTest() {
        CollectionApi collectionBookApi =  bookApiConverter.getCollectionBookApiFromCollectionBook(ModuleTestCollectionMocks.collectionBooks());
        Assert.assertEquals(ApiTestCollectionMocks.collectionApi(), collectionBookApi);
    }
}


