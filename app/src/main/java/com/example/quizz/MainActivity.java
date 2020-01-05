package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.FragmentTransaction;
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
        }
        return super.onOptionsItemSelected(item);
    }
}
