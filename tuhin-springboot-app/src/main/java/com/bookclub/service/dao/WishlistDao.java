package com.bookclub.service.dao;

import com.bookclub.model.Book;
import com.bookclub.model.WishlistItem;
import com.bookclub.service.GenericDao;

public interface WishlistDao extends GenericCrudDao<WishlistItem, String> {
}
