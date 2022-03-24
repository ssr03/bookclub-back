package com.emmett.bookclub.domain.bookclub.book;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface BookService {
    List<BookDto> getBookList(int pageNum, int pageSize);

    List<BookDto> searchBookList(String query, int pageNum, int pageSize);
}
