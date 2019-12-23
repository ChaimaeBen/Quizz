package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.quizz.Database.repository.QuestionRepository;
import com.example.quizz.ViewModel.QuestionViewModel;
import com.example.quizz.models.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    private Button startButton;
    private Button catButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.id_startButton);
        catButton = findViewById(R.id.id_categoryButton);

        catButton.setOnClickListener((View v) -> {
            DirectToCategory();
        });
        startButton.setOnClickListener((View v) -> {
            DirectToQuiz();
        });

    }




private void DirectToQuiz(){
    Intent intent = new Intent(MainActivity.this,QuestionActivity.class);
startActivity(intent);
    }

    private void DirectToCategory(){
        Intent intent = new Intent(MainActivity.this,categoryListActivity.class);
        startActivity(intent);
    }
}
