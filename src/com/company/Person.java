package com.company;

public class Person {
    private final int index;
    private final String email;
    private final String name;

    public Person(int index,String email, String name) {
        this.index = index;
        this.email = email;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
