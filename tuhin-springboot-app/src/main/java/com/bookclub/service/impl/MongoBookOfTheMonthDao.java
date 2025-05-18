package com.bookclub.service.impl;

import com.bookclub.model.Book;
import com.bookclub.model.BookOfTheMonth;
import com.bookclub.service.dao.BookOfTheMonthDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class MongoBookOfTheMonthDao implements BookOfTheMonthDao {


    @Override
    public List<BookOfTheMonth> list() {
        return getBooks();
    }

    @Override
    public BookOfTheMonth find(Object key) {
        return getBooks().get(0);
    }

    @Override
    public List<BookOfTheMonth> list(Object key) {

        int month = Integer.parseInt((String) key);

        if(999==month){
            return getBooks();
        }

        return getBooks();
    }

    private List<BookOfTheMonth> getBooks() {

        List<BookOfTheMonth> list = new ArrayList<>();

        BookOfTheMonth book1 = new BookOfTheMonth("1","ISBN123", 3);
        BookOfTheMonth book2 = new BookOfTheMonth("2","ISBN1234", 2);
        BookOfTheMonth book3 = new BookOfTheMonth("3","ISBN1235", 1);
        BookOfTheMonth book4 = new BookOfTheMonth("4","ISBN1236", 5);

        list.add(book1);
        list.add(book2);
        list.add(book3);
        list.add(book4);

        return list;
    }

    @Override
    public void add(Object entity) {

    }

    @Override
    public void update(Object entity) {

    }

    @Override
    public void remove(Object key) {

    }
}
