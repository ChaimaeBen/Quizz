package com.example.quizz.Database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.quizz.models.Category;

import java.util.List;

@Dao
public interface CategoryDao {
    @Query("SELECT * FROM Category")
    List<Category> getAll();

    @Query("DELETE FROM Category")
    void deleteAll();



    @Query("SELECT * FROM Category where category_id=:Id")
    Category getById(int Id);

    @Insert
    void insert(Category category);

    @Update
    void Update(Category category);

    @Query("DELETE FROM Category where category_id = :id")
    void deleteById(int id);
}
