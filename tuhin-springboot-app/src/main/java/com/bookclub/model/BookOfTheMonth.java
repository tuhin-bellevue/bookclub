package com.bookclub.model;

import jakarta.validation.constraints.NotEmpty;
import nonapi.io.github.classgraph.json.Id;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

public class BookOfTheMonth {

    public BookOfTheMonth() {
    }

    public BookOfTheMonth(String id, String isbn, int month) {
        this.isbn = isbn;
        this.month = month;
        this.Id=id;
    }

    @Id
    @NotEmpty(message="ISBN is a required field")
    private String Id;
    private Integer month;
    @NotNull
    @NotEmpty(message="ISBN is a required field")
    private String isbn;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "BookOfTheMonth{" +
                "Id='" + Id + '\'' +
                ", month=" + month +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
