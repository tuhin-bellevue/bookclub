package com.bookclub.service.impl;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestBookDao implements BookDao {

    //private List<Book> books = new ArrayList<>();

    public RestBookDao() {
        /*Book book = new Book("isbn1", "Math","Math Book", 50, Arrays.asList("John D","Mark C","Jack D"));
        Book book1 = new Book("isbn2", "Science","Science Book", 70, Arrays.asList("John D","Mark C","Jack D"));
        Book book2 = new Book("isbn3", "Statistics","Stat Book", 30, Arrays.asList("John D","Mark C","Jack D"));
        Book book3 = new Book("isbn4", "Story","Story Book", 100, Arrays.asList("John D","Mark C","Jack D"));
        Book book4 = new Book("isbn5", "History","History Book", 600, Arrays.asList("John D","Mark C","Jack D"));*/

       /* Book book = new Book("isbn1", "Math","Math Book", 50, "http://inforurl1.com");*/
       /* Book book1 = new Book("isbn2", "Science","Science Book", 70, "http://inforurl2.com");*/
       /* Book book2 = new Book("isbn3", "Statistics","Stat Book", 30, "http://inforurl3.com");*/
       /* Book book3 = new Book("isbn4", "Story","Story Book", 100, "http://inforurl4.com");*/
       /* Book book4 = new Book("isbn5", "History","History Book", 600, "http://inforurl5.com");*/
/**/
       /* books.add(book);*/
       /* books.add(book1);*/
       /* books.add(book2);*/
       /* books.add(book3);*/
       /* books.add(book4);*/
    }

    public Object getBooksDoc (String isbnString) {
        String openLibraryUrl ="https://openlibrary.org/api/books";
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(openLibraryUrl)
                .queryParam("bibkeys", isbnString)
                .queryParam("format", "json")
                .queryParam("jscmd", "details");

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<String> response = rest.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class);

        String jsonBookList = response.getBody();

        return Configuration.defaultConfiguration().jsonProvider().parse(jsonBookList);

    }

    public List<Book> list() {
        String isbnString = "ISBN:9780593099322,9780261102361,9780261102378,9780590302715,9780316769532";

        Object doc = getBooksDoc(isbnString);

        List<Book> books = new ArrayList<>();

        List<String> titles = JsonPath.read(doc, "$..title");
        List<String> isbns = JsonPath.read(doc, "$..bib_key");
        List<String> infoUrls = JsonPath.read(doc, "$..info_url");

        for (int index = 0; index < titles.size(); index++) {
            books.add(new Book(
                    isbns.get(index),
                    titles.get(index),
                    infoUrls.get(index)
            ));
        }

        return books;
    }

    @Override
    public Book find(String key) {
        Object doc = getBooksDoc(key);

        List<String> isbns = JsonPath.read(doc, "$..bib_key");
        List<String> titles = JsonPath.read(doc, "$..title");
        List<String> subtitle = JsonPath.read(doc, "$..details.subtitle");
        List<String> infoUrls = JsonPath.read(doc, "$..info_url");
        List<Integer> pages = JsonPath.read(doc, "$..details.number_of_pages");

        String isbn = isbns.size() > 0 ? isbns.get(0) : "N/A";
        String title = titles.size() > 0 ? titles.get(0) : "N/A";
        String desc = subtitle.size() > 0 ? subtitle.get(0) : "N/A";
        String infoUrl = infoUrls.size() > 0 ? infoUrls.get(0) : "N/A";
        int numOfPages = pages.size() > 0 ? pages.get(0) : 0;

        Book book = new Book(isbn, title, infoUrl);
        return book;
    }
}
