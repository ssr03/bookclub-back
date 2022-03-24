package com.emmett.bookclub.domain.bookclub.book;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/book")
public class BookController {
    private final BookService bookService;

    /**
     * Subject: 추천도서 리스트
     * Description:
     * */
    @GetMapping("/list")
    public ResponseEntity<List<BookDto>> getBookList(@RequestParam(name="pageNum") int pageNum,
                                                     @RequestParam(name="pageSize", required = false, defaultValue = "10") int pageSize) {
        List<BookDto> result = bookService.getBookList(pageNum, pageSize);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Subject: 도서검색
     * */
    @GetMapping("/search")
    public ResponseEntity<List<BookDto>> searchBookList(@RequestParam(name="pageNum") int pageNum,
                                                        @RequestParam(name="pageSize", required = false, defaultValue = "10") int pageSize,
                                                        @RequestParam(name="query") String query) {
        List<BookDto> result = bookService.searchBookList(query, pageNum, pageSize);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
