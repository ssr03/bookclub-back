package com.emmett.bookclub.domain.bookclub.book;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
    String total;
    String start;
    String display;
    List<Item> items;

    @Getter
    @Setter
    public static class Item{
        String title;
        String image;
        String author;
        String publisher;
        String pubdate;
        String isbn;
        String description;
    }
}
