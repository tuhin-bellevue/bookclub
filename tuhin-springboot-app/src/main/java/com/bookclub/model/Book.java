package com.bookclub.model;

import java.util.List;

public class Book {

    private String isbn;
    private String title;
    private String description;
    private int numOfPages;
    /*private List<String> authors;*/
    private String infoUrl;

    public Book() {
    }

    public Book(String isbn, String title, String infoUrl) {
        this.isbn = isbn;
        this.title = title;
        /*this.description = description;
        this.numOfPages = numOfPages;*/
        //this.authors = authors;
        this.infoUrl=infoUrl;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public String getInfoUrl() {
        return infoUrl;
    }

    public void setInfoUrl(String infoUrl) {
        this.infoUrl = infoUrl;
    }

    /*public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }*/


    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", numOfPages=" + numOfPages +
                ", infoUrl=" + infoUrl +
                '}';
    }
}
