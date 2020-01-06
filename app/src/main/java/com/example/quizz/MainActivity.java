package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.quizz.Database.repository.CategoryRepository;
import com.example.quizz.Database.repository.QuestionRepository;
import com.example.quizz.models.Category;
import com.example.quizz.models.Question;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    private QuestionRepository mrep;
    private CategoryRepository crep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        mrep = new QuestionRepository(this.getApplication());
        crep = new CategoryRepository(this.getApplication());



/*
   Category c1 = new Category(0,"Film","difficulty level: easy");
        Category c2 = new Category(0,"History","difficulty level: meduim");
        Category c3 = new Category(0,"Geography","difficulty level: hard");
        Category c4 = new Category(0,"Television","difficulty level: easy");
        Category c5 = new Category(0,"Science & Nature","difficulty level: meduim");
        Category c6 = new Category(0,"Board Games","difficulty level: easy");
        Category c7 = new Category(0,"Animals","difficulty level: hard");
        Category c8 = new Category(0,"Sports","difficulty level: easy");
        Category c9 = new Category(0,"Vehicles","difficulty level: meduim");
        Category c10 = new Category(0,"Mythology","difficulty level: easy");
        Category c11= new Category(0,"Politics","difficulty level: hard");

        crep.insertCategories(c1);
        crep.insertCategories(c2);
        crep.insertCategories(c3);
        crep.insertCategories(c4);
        crep.insertCategories(c5);
        crep.insertCategories(c6);
        crep.insertCategories(c7);
        crep.insertCategories(c8);
        crep.insertCategories(c9);
        crep.insertCategories(c10);
        crep.insertCategories(c11);


        Question q1 = new Question(0,"A is correct","A","B","C",1,1);
        Question q2 = new Question(0,"C is correct","A","B","C",3,2);
        Question q3 = new Question(0,"B is correct","A","B","C",2,3);
        Question q4 = new Question(0,"A is correct","A","B","C",1,4);
        Question q5 = new Question(0,"B is correct","A","B","C",2,5);
        Question q6 = new Question(0,"C is correct","A","B","C",3,6);
        Question q7 = new Question(0,"C is correct","A","B","C",3,7);
        Question q8 = new Question(0,"A is correct","A","B","C",1,8);
        Question q9 = new Question(0,"B is correct","A","B","C",2,9);
        Question q10 = new Question(0,"B is correct","A","B","C",2,10);
        Question q11 = new Question(0,"A is correct","A","B","C",1,11);
        Question q12 = new Question(0,"A is correct","A","B","C",1,1);

        mrep.insert(q1);
        mrep.insert(q2);
        mrep.insert(q3);
        mrep.insert(q4);
        mrep.insert(q5);
        mrep.insert(q6);
        mrep.insert(q7);
        mrep.insert(q8);
        mrep.insert(q9);
        mrep.insert(q10);
        mrep.insert(q11);
        mrep.insert(q12);


        */


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.searchlogobigger);

        if (findViewById(R.id.frame_main) != null) {
            if (savedInstanceState != null) {
                return;
            }
            fragmentManager.beginTransaction().add(R.id.frame_main, new LoginFragment()).commit();
        }



    }@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main_menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.rankingItem:
                /* DO EDIT */
                return true;
                     case R.id.logout:
                SessionLogin session = new SessionLogin(this.getApplicationContext());
                session.setLogin(false);
                return true;
            case R.id.profileItem:
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ProfileFragment llf = new ProfileFragment();
                ft.replace(R.id.frame_main, llf);
                ft.commit();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
