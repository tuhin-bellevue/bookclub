package com.bookclub.service.impl;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemBookDao implements BookDao {

    private List<Book> books = new ArrayList<>();

    public MemBookDao() {
        Book book = new Book("isbn1", "Math","Math Book", 50, Arrays.asList("John D","Mark C","Jack D"));
        Book book1 = new Book("isbn2", "Science","Science Book", 70, Arrays.asList("John D","Mark C","Jack D"));
        Book book2 = new Book("isbn3", "Statistics","Stat Book", 30, Arrays.asList("John D","Mark C","Jack D"));
        Book book3 = new Book("isbn4", "Story","Story Book", 100, Arrays.asList("John D","Mark C","Jack D"));
        Book book4 = new Book("isbn5", "History","History Book", 600, Arrays.asList("John D","Mark C","Jack D"));

        books.add(book);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
    }

    @Override
    public List<Book> list() {
        return this.books;
    }

    @Override
    public Book find(String key) {
        for(Book book: this.books){
            if(book.getIsbn().equals(key)){
                return book;
            }
        }
        return new Book();
    }

    @Override
    public void add(Book entity) {

    }

    @Override
    public void update(Book entity) {

    }

    @Override
    public boolean remove(Book entity) {
        return false;
    }
}
