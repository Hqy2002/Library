package com.library.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private String bookname;
    private String author;
    private String publisher;
    private float price;
    private String borrowed;
}
