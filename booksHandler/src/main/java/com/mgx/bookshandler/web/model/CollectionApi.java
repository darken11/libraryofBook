package com.mgx.bookshandler.web.model;


import com.mgx.bookshandler.constants.ApiConstants;
import com.mgx.bookshandler.web.customException.CollectionBooksException;
import lombok.*;

import java.util.Collection;
import java.util.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
public class CollectionApi implements Comparable<CollectionApi> {
    private String name;
    private Date creationTimestamp;
    private Date updateTimestamp;
    private Collection<BookApi> booksApi;

    @Override
    public int compareTo(CollectionApi o) {
        if(o.getName()==null)throw new CollectionBooksException(ApiConstants.collectionBookNotFound);
        return this.name.compareTo(o.name);
    }
}
