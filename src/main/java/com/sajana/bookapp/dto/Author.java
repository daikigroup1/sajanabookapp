package com.sajana.bookapp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Author {
    private int authorId;
    private String name;
    private String address;
}
