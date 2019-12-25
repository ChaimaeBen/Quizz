package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.quizz.Database.repository.QuestionRepository;
import com.example.quizz.models.Question;

import java.util.List;

public class ResultActivity extends AppCompatActivity {
    private QuestionRepository mrep;
    private List<Question> mQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mrep = new QuestionRepository(this.getApplication());

       // mQuestions= mrep.getCategories();





    }
}
