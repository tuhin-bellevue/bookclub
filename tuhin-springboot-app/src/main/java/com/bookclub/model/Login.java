package com.bookclub.model;

import jakarta.validation.constraints.NotEmpty;
import org.jetbrains.annotations.NotNull;

public class Login {

    @NotNull
    @NotEmpty(message="username is a required field")
    private String username;

    @NotNull
    @NotEmpty(message="password is a required field")
    private String password;

    public Login() {
    }

    public Login(@NotNull String username, @NotNull String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
