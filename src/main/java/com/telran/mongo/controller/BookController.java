package com.telran.mongo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.telran.mongo.model.entity.Book;
import com.telran.mongo.model.entity.User;
import com.telran.mongo.model.web.UserRequest;
import com.telran.mongo.repository.BookRepository;
import com.telran.mongo.repository.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/books")
    public Book save(@RequestBody Book book) {

        Book savedBook = bookRepository.save(book);

        return savedBook;
    }

    @GetMapping("/books")
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody UserRequest userRequest) {

        Book book = bookRepository
                .findById(userRequest.getBookId())
                .orElse(null);

        User user = User.builder()
                .email(userRequest.getEmail())
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .book(book)
                .build();
        return userRepository.save(user);
    }

    @PutMapping("/users/{id}")
    public User updateAttendingClasses(
            @PathVariable("id") String userId,
            @RequestBody List<String> classes) {

        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            return null;
        }

        if (user.getAttendingClasses() == null) {
            user.setAttendingClasses(new HashSet<>());
        }

        user.getAttendingClasses().addAll(classes);

        return userRepository.save(user); //update
    }

    @SneakyThrows
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(
                        Book
                                .builder()
                                .bookName("The song of ice and fire") //BookBuilder
                                .authorName("George Martin") //BookBuilder
                                .yearOfIssuing(1999) //BookBuilder
                                .build() //new Book
                );

        System.out.println(json);

        json = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(UserRequest
                        .builder()
                        .email("asd")
                        .lastName("asd")
                        .firstName("asd")
                        .bookId("asd")
                        .build()
                );

        System.out.println(json);
    }
}
