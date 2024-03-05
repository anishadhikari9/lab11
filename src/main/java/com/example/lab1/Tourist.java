package com.example.lab1;

public class Tourist{
    private int id;
    private String Name;
    private int age;
    private String Nationality;
    public Tourist(int id, String Name, int age, String Nationality) {
        this.id = id;
        this.Name = Name;
        this.age = age;
        this.Nationality = Nationality;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return Name;
    }
    public int getage() {
        return age;
    }
    public String getNationality() {
        return Nationality;
    }
}