package com.example.quizz.Database.repository;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.quizz.Database.dao.CategoryDao;
import com.example.quizz.Database.dao.QuestionDao;
import com.example.quizz.Database.dao.UserDao;
import com.example.quizz.models.Category;
import com.example.quizz.models.Question;
import com.example.quizz.models.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = { Category.class,Question.class, User.class}, version = 13, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CategoryDao categoryDao();
    public abstract QuestionDao questionDao();
    public abstract UserDao userDao();

    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 1;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        static AppDatabase getDatabase(final Context context)
        {
            if (INSTANCE == null) {
                synchronized (AppDatabase.class) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                AppDatabase.class, "quiz_database").allowMainThreadQueries().fallbackToDestructiveMigration()
                                .build();
                    }
                }
            }
            return INSTANCE;
        }


    };





