package com.example.quizz.Database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.quizz.models.Category;
import com.example.quizz.models.Question;

import java.util.List;

@Dao
public interface QuestionDao   {

    @Query("SELECT * FROM Question")
  List<Question>getAll();

    @Query("SELECT * FROM Question ORDER BY RANDOM() LIMIT 10")
    List<Question> getAllRandom();



    @Query("SELECT * FROM Question where answer_number LIKE :number")
    Question getByNumber(String number);

    @Query("SELECT * FROM Question where question_id=:Id")
    Question getById(int Id);



    @Query("DELETE FROM Question")
    void deleteAll();



    @Query("SELECT * FROM Question where category_id =:cat")
    List<Question>getQuestionsWithCategory(int cat);

 @Insert
    void insert(Question... question);

    @Update
    void Update(Question question);

    @Query("DELETE FROM Question where question_id = :id")
    void deleteById(int id);


}