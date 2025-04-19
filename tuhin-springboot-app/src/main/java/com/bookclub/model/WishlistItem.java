package com.bookclub.model;

import jakarta.validation.constraints.NotEmpty;
import org.jetbrains.annotations.NotNull;

public class WishlistItem {

    public WishlistItem() {
    }

    public WishlistItem(@NotNull String isbn, @NotNull String title) {
        this.isbn = isbn;
        this.title = title;
    }

    @NotNull
    @NotEmpty(message="ISBN is a required field")
    private String isbn;
    @NotNull
    @NotEmpty(message="Title is a required field")
    private String title;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "WishlistItem{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
