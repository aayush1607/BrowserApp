package com.example.browser;

public class UserHelperClass {
    String name,username,pass;

    public UserHelperClass() {
    }

    public UserHelperClass(String name, String username, String pass) {
        this.name = name;
        this.username = username;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
