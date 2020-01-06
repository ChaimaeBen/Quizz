package com.example.quizz.Database.dao;



import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.quizz.models.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM User")
     List<User> getAll();

    @Query("SELECT * FROM User where email LIKE :email")
    User getUserByEmail(String email);

    @Query("DELETE FROM User")
    void deleteAll();

    @Query("select*from User where Email=:em")
    User verifyEmail(String em);

    @Query("SELECT * FROM User where Email=:em and Password=:p" )
    User verifyUser(String em,String p);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Query("UPDATE User SET newHigh = :highscore WHERE email = :email ")
    void UpdateScore(int highscore,String email);

    @Query("SELECT * FROM User where UserId=:Id")
    int getById(int Id);

    @Query("DELETE FROM User where userId = :userId")
    void deleteById(int userId);


}
