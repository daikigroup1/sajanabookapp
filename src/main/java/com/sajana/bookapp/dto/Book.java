package com.sajana.bookapp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Book {
    private int bookId;
    private String name;
    private int publisherId;
    private int authorId;
    private double price;
}
