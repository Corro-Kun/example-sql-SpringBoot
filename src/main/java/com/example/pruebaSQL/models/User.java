package com.example.pruebaSQL.models;

public class User {

    private int id;

    private String name;
    private String last;

    public User(){

    }

    public User(String name, String last, int id){
        this.name = name;
        this.last = last;
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getLast(){
        return this.last;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setLast(String last){
        this.last = last;
    }
}
