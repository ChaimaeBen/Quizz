package com.example.quizz.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(indices = {@Index("category_id")},tableName = "Category")

public  class Category {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "category_id")

    public int category_id;
    public String category_name;
    public String category_details;

    public Category(int category_id, String category_name, String category_details) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.category_details = category_details;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_details() {
        return category_details;
    }

    public void setCategory_details(String category_details) {
        this.category_details = category_details;
    }

    @Override
    public String toString() {
        return category_name;
    }

}
