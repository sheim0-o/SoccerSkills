package com.example.myapplication;

public class API_Registration {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public API_Registration(String firstName, String lastName, String email, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getNameReg() { return firstName; }

    public String getLastNameReg() {
        return lastName;
    }

    public String getEmailReg() {
        return email;
    }

    public String getPasswordReg() {
        return password;
    }
}
