package com.JBDL.Assignment2;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, Integer> {
    @Query("{author_name:?0}")
    public List<Book> getBooksByAuthor(@Param("author_name") String author_name);
}
