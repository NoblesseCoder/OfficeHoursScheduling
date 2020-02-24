package com.company;

public class Person {
    private final String name;
    private final String email;

    public Person(String name,String email) {
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
