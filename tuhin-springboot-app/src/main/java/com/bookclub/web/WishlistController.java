package com.bookclub.web;

import com.bookclub.service.dao.WishlistDao;
import com.bookclub.service.impl.MongoWishlistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookclub.model.WishlistItem;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {

    @Autowired
    public void setWishlistDao(WishlistDao wishlistDao) {
        this.wishlistDao = wishlistDao;
    }

    private WishlistDao wishlistDao;
    @GetMapping
    public String showWishlist(Model model) {
        /*WishlistDao dao = new MongoWishlistDao();
        List<WishlistItem> wishlist = dao.list();*/
        List<WishlistItem> wishlist = wishlistDao.list();
        model.addAttribute("wishlist", wishlist);
        return "wishlist/list";
    }

    @GetMapping("/new")
    public String wishlistForm(Model model) {
        model.addAttribute("wishlistItem", new WishlistItem());
        return "wishlist/new";
    }

    @PostMapping
    public String addWishlistItem(@Valid @ModelAttribute WishlistItem wishlistItem,
                                  BindingResult bindingResult) {

        System.out.println(wishlistItem.toString());

        System.out.println(bindingResult.getAllErrors());

        if (bindingResult.hasErrors()) {
            return "wishlist/new";
        }

        wishlistDao.add(wishlistItem);

        return "redirect:/wishlist";
    }

}
