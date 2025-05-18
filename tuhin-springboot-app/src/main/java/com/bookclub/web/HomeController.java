package com.bookclub.web;

import com.bookclub.model.Book;
import com.bookclub.model.BookOfTheMonth;
import com.bookclub.service.dao.BookOfTheMonthDao;
import com.bookclub.service.impl.MongoBookOfTheMonthDao;
import com.bookclub.service.impl.RestBookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    BookOfTheMonthDao bookOfTheMonthDao = new MongoBookOfTheMonthDao();

    @GetMapping
    public String showHome(Model model){

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int calMonth = cal.get(Calendar.MONTH)+1;



        RestBookDao bookDao = new RestBookDao();
        List<BookOfTheMonth> monthlyBooks = bookOfTheMonthDao.list(Integer.toString(calMonth));


        StringBuilder isbnBuilder = new StringBuilder();
        isbnBuilder.append("ISBN");

        for(BookOfTheMonth monthlyBook: monthlyBooks) {
            isbnBuilder.append(monthlyBook.getIsbn()).append(",");
        }

        String isbnString = isbnBuilder.toString().substring(0, isbnBuilder.toString().length()-1);

        List<Book> books = bookDao.list(isbnString);
        model.addAttribute("books", books);
        for (Book book: books){
            System.out.println(book.toString());
        }
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String getMonthlyBook(@PathVariable("id") String id, Model model) {
        String isbn = id;
        System.out.println(id);

        RestBookDao bookDao = new RestBookDao();
        Book book = bookDao.find(isbn);

        System.out.println(book.toString());

        model.addAttribute("book", book);
        return "monthly-books/view";
    }

    //@RequestMapping(method = RequestMethod.GET, path = "/about")
    @GetMapping("/about")
    public String showAboutUs(Model model){
        return "about";
    }


    //@RequestMapping(method = RequestMethod.GET, path = "/contact")
    @GetMapping("/contact")
    public String showContactUs(Model model){
        return "contact";
    }

    @GetMapping("/show")
    public String showBookOfTheMonth(Model model) {
        model.addAttribute("books", bookOfTheMonthDao.list(999));
        return "monthly-books/list";
    }
}
