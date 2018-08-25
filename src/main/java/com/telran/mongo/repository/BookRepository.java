package com.telran.mongo.repository;

import com.telran.mongo.model.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

//import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
