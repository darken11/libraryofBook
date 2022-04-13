package com.mgx.bookshandler.repositories;


import com.mgx.bookshandler.entities.CollectionBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface CollectionBookRepository extends JpaRepository<CollectionBooks,Long> {
    @Query("SELECT b FROM CollectionBooks b WHERE b.name=:name")
   CollectionBooks findCollectionByName(@Param("name") String name);
}
