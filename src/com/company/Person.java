package com.company;

public class Person {
    private final String name;
    private  String status;
    private  String email;

    public Person(String name,String email, String status) {
        this.name = name;
        this.status = status;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getEmail() {
        return email;
    }

    public void setStatus(String status){
        this.status = status;
    }
}
