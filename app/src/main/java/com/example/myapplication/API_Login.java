package com.example.myapplication;

public class API_Login {
    private String email;
    private String password;

    public API_Login(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getEmailLog() {
        return email;
    }

    public String getPasswordLog() {
        return password;
    }
}
