package com.example.finalprojectnew.Class;

public class Users {
    private String id;
    private String name;
    private String email;
    private String password;

    public Users() {
    }

    public Users(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return email;
    }

    public void setNumber(String number) {
        this.email = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
