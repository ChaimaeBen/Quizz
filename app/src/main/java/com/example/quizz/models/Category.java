package com.example.quizz.models;

public  class Category {
    public String id;
    public String name;
    public String details;

    public Category(String id, String name, String details) {
        this.id = id;
        this.name = name;
        this.details = details;
    }

    @Override
    public String toString() {
        return name;
    }

}
