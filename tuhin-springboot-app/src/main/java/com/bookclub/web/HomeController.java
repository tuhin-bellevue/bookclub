package com.bookclub.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String showHome(Model model){
        return "index";
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
}
