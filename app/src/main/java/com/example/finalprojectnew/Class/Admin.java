package com.example.finalprojectnew.Class;

public class Admin {
    private String id;
    private String number;
    private String email;
    private String password;

    public Admin( String id,String number, String email, String password) {
        this.id = id;
        this.number = number;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
