package com.example.quizz;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;


import com.example.quizz.Database.repository.AppDatabase;
import com.example.quizz.Database.repository.CategoryRepository;
import com.example.quizz.models.Category;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;


import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class DaoTesting {
  private AppDatabase db;
  private CategoryRepository crep;


@Before
public void  initDB(){
    Context context = ApplicationProvider.getApplicationContext();
    db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
    crep = new CategoryRepository(ApplicationProvider.getApplicationContext());

}


    @After
    public void closeDB() throws IOException {
        db.close();
    }


    @Test
    public void writeInsert() throws Exception{
        Category cat = new Category(0, "testcategory",   "difficulty: hard");
crep.insertCategories(cat);

    Category find= crep.getCategoryByName("testcategory");

        assertEquals(find.getCategory_name(),cat.category_name);
}

}
