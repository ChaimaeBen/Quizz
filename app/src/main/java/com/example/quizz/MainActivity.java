package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.TextView;

import com.example.quizz.Database.repository.CategoryRepository;
import com.example.quizz.Database.repository.QuestionRepository;
import com.example.quizz.models.Category;
import com.example.quizz.models.Question;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    private QuestionRepository mrep;
    private CategoryRepository crep;
    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";

    private TextView textViewHighscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager =getSupportFragmentManager();

        if(findViewById(R.id.frame_main)!=null){
            if(savedInstanceState!=null){
                return;
            }
            //add Homefragment to mainActivity
            fragmentManager.beginTransaction().add(R.id.frame_main,new LoginFragment()).commit();

        }





    }

}
