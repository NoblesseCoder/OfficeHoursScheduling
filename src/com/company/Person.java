package com.company;

public class Person {
    private final String name;
    private final String email;
    private  String status;

    public Person(String name, String email, String status) {
        this.name = name;
        this.email = email;
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }
}
