package com.example.quizz.Database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.quizz.models.Question;

import java.util.List;

@Dao
public interface QuestionDao   {

    @Query("SELECT * FROM quiz_question")
  List<Question>getAll();

    @Query("SELECT * FROM quiz_question where answer_number LIKE :number")
    Question getByNumber(String number);

    @Query("SELECT * FROM quiz_question where question_id=:Id")
    Question getById(int Id);

    @Query("DELETE FROM quiz_question")
    void deleteAll();


 @Insert
    void insert(Question... question);

    @Update
    void Update(Question question);

    @Query("DELETE FROM quiz_question where question_id = :id")
    void deleteById(int id);


}