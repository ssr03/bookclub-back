package com.emmett.bookclub.domain.bookclub.book;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService{
    @Value("${naver.open-api.url}")
    String url;

    @Value("${naver.client.id}")
    String clientId;
    @Value("${naver.client.secret}")
    String clientSecret;
    private final RestTemplate restTemplate;

    @Override
    public List<BookDto> getBookList(int pageNum, int pageSize) {
        List<BookDto> list = new LinkedList<>();
        // TODO://추천도서 리스트 조회
        return list;
    }

    @Override
    public List<BookDto> searchBookList(String query, int pageNum, int pageSize) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", clientId);
        headers.set("X-Naver-Client-Secret", clientSecret);

        HttpEntity httpEntity = new HttpEntity(headers);

        String request_url = url + "/search/book.json?query="+query+"&start=" + pageNum + "&display=" + pageSize;

        ResponseEntity<Response> responseEntity = restTemplate.exchange(
                request_url,
                HttpMethod.GET,
                httpEntity,
                Response.class
        );

        Response response = responseEntity.getBody();

        List<BookDto> list = new LinkedList<>();
        response.items.stream().forEach(item->{
            list.add(new BookDto(
                    item.getTitle(),
                    item.getAuthor(),
                    item.getPublisher(),
                    item.getImage(),
                    item.getIsbn()
            ));
        });
        return list;
    }
}
