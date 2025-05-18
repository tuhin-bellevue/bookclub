package com.bookclub.web;


import com.bookclub.model.BookOfTheMonth;
import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.BookOfTheMonthDao;
import com.bookclub.service.impl.MongoBookOfTheMonthDao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/bookOfTheMonth")
public class AdminController {

    BookOfTheMonthDao bookOfTheMonthDao = new MongoBookOfTheMonthDao();

    @GetMapping("/show")
    public String showBookOfTheMonth(Model model) {
        model.addAttribute("books", bookOfTheMonthDao.list(999));
        return "monthly-books/list";
    }

    @GetMapping("/form")
    public String bookOfTheMonthForm(Model model) {
        model.addAttribute("months", getMonths());
        model.addAttribute("book", new BookOfTheMonth());
        return "monthly-books/form"; // assuming the Thymeleaf form is named 'form.html'
    }


    @PostMapping("/add")
    public void addBookOfTheMonth(@RequestBody BookOfTheMonth book) {

    }

    @PostMapping
    public String addWishlistItem(@Valid @ModelAttribute BookOfTheMonth bookOfTheMonth,
                                  BindingResult bindingResult) {

        System.out.println(bookOfTheMonth.toString());

        System.out.println(bindingResult.getAllErrors());

        if (bindingResult.hasErrors()) {
            return "monthly-books/new";
        }

        bookOfTheMonthDao.add(bookOfTheMonth);

        return "redirect:/monthly-books/list";
    }

    @PutMapping("/remove")
    public String removeBookOfTheMonth(@PathVariable String id){
        bookOfTheMonthDao.remove(id);
        return "redirect:/monthly-books/list";
    }

    @GetMapping("/get")
    public Map<Integer, String> getMonths() {
        Map<Integer, String> months = new HashMap<>();
        months.put(1,"January");
        months.put(2,"February");
        months.put(3,"March");
        months.put(4,"April");
        months.put(5,"May");
        months.put(6,"June");
        months.put(7,"July");
        months.put(8,"August");
        months.put(9,"September");
        months.put(10,"October");
        months.put(11,"November");
        months.put(12,"December");
        return months;
    }

}
