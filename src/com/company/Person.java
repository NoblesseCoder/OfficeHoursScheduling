package com.company;

public class Person {

    private int idNum;
    private final String name;
    private  String status;
    private  String email;

    public Person(int idNum ,String name,String status,String email) {
        this.name = name;
        this.status = status;
        this.email = email;
        this.idNum =idNum;
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

    public int getIdNum() {
        return idNum;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setIdNum(int num){
        this.idNum = num;
    }
}
