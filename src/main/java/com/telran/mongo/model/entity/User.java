package com.telran.mongo.model.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document
@Builder
public class User {

    @Id
    private String id;

    private String firstName;
    private String lastName;

    @Indexed(unique = true)
    private String email;
    //"email":"user@site.com"

    //"book":{
    //  "id":"asdas",
    //  "bookName":"name"
    // }
    //@DBRef

    //"book": {
    // "collection":"books",
    // "bookId":"asdas"
    //}
    @DBRef
    private Book book;

    private Set<String> attendingClasses;
}
