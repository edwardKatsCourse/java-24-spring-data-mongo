package com.telran.mongo.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document()
public class Book /*-> book -> book + s = books*/ {

    @Id
    private String id;
    private String bookName;
    private String authorName;
    private Integer yearOfIssuing;
}