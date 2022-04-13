package com.mgx.bookshandler.web.model;


import com.mgx.bookshandler.constants.ApiConstants;
import com.mgx.bookshandler.web.customException.CollectionBooksException;
import lombok.*;

import java.util.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
public class BookApi implements Comparable<BookApi> {
    private Long idCollection;
    private Long idBook;
    private String title;
    private String author;
    private String isbn;
    private Date creationTimestamp;
    private Date updateTimestamp;

    @Override
    public int compareTo(BookApi o) {
        if(o.getTitle()==null)throw new CollectionBooksException(ApiConstants.bookNotFound);
        return this.title.compareTo(o.title);
    }
}
