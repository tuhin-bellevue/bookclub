package com.bookclub.service.dao;


import com.bookclub.model.WishlistItem;
import com.bookclub.service.impl.MemWishlistDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemWishlistDaoTest {

    private MemWishlistDao wishlistDao;

    @BeforeEach
    void setUp() {
        wishlistDao = new MemWishlistDao();
    }

    @Test
    void testList_ReturnsAllWishlistItems() {
        List<WishlistItem> items = wishlistDao.list();

        assertNotNull(items, "List should not be null");
        assertEquals(2, items.size(), "Expected 2 wishlist items");
        assertEquals("ISBN1234", items.get(0).getIsbn(), "First item's ISBN should match");
        assertEquals("ISBN6789", items.get(1).getIsbn(), "Second item's ISBN should match");
    }

    @Test
    void testFind_ReturnsCorrectWishlistItem() {
        WishlistItem item = wishlistDao.find("ISBN6789");

        assertNotNull(item, "Wishlist item should not be null");
        assertEquals("ISBN6789", item.getIsbn(), "ISBN should match");
        assertEquals("Title2", item.getTitle(), "Title should match");
    }
}

