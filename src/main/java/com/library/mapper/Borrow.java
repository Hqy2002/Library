package com.library.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Borrow {
    int bid;
    String username;
    String book;
    public Borrow() {

    }
}
