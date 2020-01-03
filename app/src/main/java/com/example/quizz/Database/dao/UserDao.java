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

    @Query("SELECT * FROM User where firstname LIKE :username")
    User getByFirstName(String username);

    @Query("DELETE FROM User")
    void deleteAll();

    @Query("select*from User where Email=:em")
    User verifyEmail(String em);

    @Query("SELECT * FROM User where Email=:em and Password=:p" )
    User verifyUser(String em,String p);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Update
    void Update(User user);

    @Query("SELECT * FROM User where UserId=:Id")
    int getById(int Id);

    @Query("DELETE FROM User where userId = :userId")
    void deleteById(int userId);


}
