package com.emmett.bookclub.domain.bookclub.book;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BookDto{
    String title;
    String author;
    String publisher;
    String filePath;
    String isbn;

    public BookDto(String title, String author, String publisher, String filePath, String isbn){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.filePath = filePath;
        this.isbn = isbn;
    }
}
