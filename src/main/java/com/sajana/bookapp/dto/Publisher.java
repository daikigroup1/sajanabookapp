package com.sajana.bookapp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Publisher {
    private int publisherId;
    private String name;
    private String address;
}
