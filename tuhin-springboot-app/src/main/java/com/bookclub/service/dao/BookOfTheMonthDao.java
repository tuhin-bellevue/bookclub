package com.bookclub.service.dao;

import com.bookclub.service.GenericDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bookOfTheMonthDao")
public interface BookOfTheMonthDao<BookOfTheMonth, String> extends GenericDao {

}
