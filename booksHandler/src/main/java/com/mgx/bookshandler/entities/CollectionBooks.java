package com.mgx.bookshandler.entities;

import com.mgx.bookshandler.constants.ApiConstants;
import com.mgx.bookshandler.web.customException.CollectionBooksException;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class CollectionBooks implements Serializable, Comparable<CollectionBooks> {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCollectionBook;
    @Column(unique = true)
    private String name;
    @Column(name = "date_create")
    private Date creationTimestamp;
    @Column(name = "date_update")
    private Date updateTimestamp;
    @OneToMany(mappedBy = "collectionBooks",cascade = CascadeType.ALL)
    private Collection<Book> books;

    @Override
    public int compareTo(CollectionBooks o) {
        if(o.getName()==null)throw new CollectionBooksException(ApiConstants.collectionBookNotFound);
        return this.name.compareTo(o.name);
    }
}
