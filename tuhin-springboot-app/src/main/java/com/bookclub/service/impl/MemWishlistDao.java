package com.bookclub.service.impl;

import com.bookclub.model.Book;
import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;

import java.util.ArrayList;
import java.util.List;

public class MemWishlistDao implements WishlistDao {

    private List<WishlistItem> wishlistItems;

    public MemWishlistDao() {
        wishlistItems = new ArrayList<>();
        WishlistItem item1 = new WishlistItem("ISBN1234", "Title1");
        WishlistItem item2 = new WishlistItem("ISBN6789", "Title2");

        wishlistItems.add(item1);
        wishlistItems.add(item2);
    }

    @Override
    public List<WishlistItem> list() {
        return wishlistItems;
    }

    @Override
    public WishlistItem find(String key) {
        for(WishlistItem item: this.wishlistItems){
            if(item.getIsbn().equals(key)){
                return item;
            }
        }
        return new WishlistItem();
    }
}
