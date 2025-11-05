package com.example.loginneptunprojekt;

public class User {
    private String name;
    private String neptun;

    public User(String name, String neptun) {
        this.name = name;
        this.neptun = neptun;
    }

    public String getName() {
        return name;
    }

    public String getNeptun() {
        return neptun;
    }
}
