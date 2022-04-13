package com.mgx.bookshandler.entities;


import com.mgx.bookshandler.constants.ApiConstants;
import com.mgx.bookshandler.web.customException.CollectionBooksException;
import lombok.*;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class Book implements Serializable, Comparable<Book> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBook;
    private String title;
    private String author;
    private String isbn;
    @Column(name = "date_create")
    private Date creationTimestamp;
    @Column(name = "date_update")
    private Date updateTimestamp;
    @ManyToOne
    @JoinColumn(name = "COLLECTION_ID")
    private CollectionBooks collectionBooks;

    @Override
    public int compareTo(Book o) {
        if(o.getTitle()==null)throw new CollectionBooksException(ApiConstants.bookNotFound);
        return this.title.compareTo(o.title);
    }
}
