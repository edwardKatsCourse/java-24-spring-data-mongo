package com.telran.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataMongoDemoApplication {

    /**
     * MongoDB
     *
     * 1. Где живет база данных МОНГО??
     * 2. Как к ней подключиться из Java прокта?
     * - mongo driver
     * - spring-data starter для mongo
     *
     * SQL          MONGO              JAVA
     * Table      Collection        List<Book>
     * Row         Document         Book
     * Column       Field           book.name
     * Index        Index              --
     *
     * Index
     * - primary key - уникальный ID записи (книги)
     * - unique      - сделать ЕЩЕ какое-то поле уникальным
     *
     * firstName
     * lastName
     * email (indexed: unique=true)
     *
     *
     * Spring Data Repository persistence policy
     * .save()
     * Если мы сохраняем объект, в котором поле ID = null -> сохраняет
     * Если мы сохраняем объект, в котором поле ID не (!=) null -> обновляет
     *
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringDataMongoDemoApplication.class, args);
    }
}
