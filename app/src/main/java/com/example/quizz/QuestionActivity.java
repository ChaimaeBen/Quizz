package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizz.Database.repository.QuestionRepository;
import com.example.quizz.models.Question;

import java.util.Collections;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {
    private QuestionRepository mrep;
    private TextView TextQuestions, TextScore,TextCount,TextTime;
    private RadioGroup group;
    private RadioButton rad1, rad2, rad3;
    private Question current;
    private Button next;
    private int score;
    private boolean answer;
    private List<Question> mQuestions;
    private int questionCounter;
    private int questionTotal;
    private ColorStateList textDefaultColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

next = findViewById(R.id.id_next);
        TextQuestions =findViewById(R.id.id_question);
        TextScore=findViewById(R.id.id_totalText);
        TextTime=findViewById(R.id.id_countdown);
        TextCount=findViewById(R.id.id_questionCount);
        group = findViewById(R.id.radioGroup);
        rad1 = findViewById(R.id.id_radio1);
        rad2 = findViewById(R.id.id_radio2);
        rad3 = findViewById(R.id.id_radio3);

        textDefaultColor = rad3.getTextColors();

        mrep = new QuestionRepository(this.getApplication());
        mQuestions= mrep.getAllQuestions();
        questionTotal = mQuestions.size();
        Collections.shuffle(mQuestions);

        showNextQuestion();




        next.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(!answer){
            if(rad1.isChecked()||rad2.isChecked()||rad3.isChecked()){
                AnswerChecker();
            }else {
                Toast.makeText(QuestionActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
            }
            }else{
                showNextQuestion();
            }
        }

});



    }
private void AnswerChecker(){
        answer = true;

        RadioButton select = findViewById(group.getCheckedRadioButtonId());
        int number = group.indexOfChild(select)+1;

        if(number == current.getAnswer_number()){
            score++;
            TextScore.setText("Score: " +score);
        }
        showSolution();
}

    private void showNextQuestion(){
        rad1.setTextColor(textDefaultColor);
        rad2.setTextColor(textDefaultColor);
        rad3.setTextColor(textDefaultColor);
        group.clearCheck();

        if(questionCounter<questionTotal) {
            current = mQuestions.get(questionCounter);

            TextQuestions.setText(current.getQuestion());
            rad1.setText(current.getChoice1());
            rad2.setText(current.getChoice2());
            rad3.setText(current.getChoice3());

            questionCounter++;
            TextCount.setText("Question: " + questionCounter + "/" + questionTotal);
            answer = false;
            next.setText("confirm");
        }else{
            endQuiz();

        }}


    private void endQuiz(){
        finish();
    }



    private void showSolution() {
        rad2.setTextColor(Color.RED);
        rad1.setTextColor(Color.RED);
        rad3.setTextColor(Color.RED);

        switch (current.getAnswer_number()) {
            case 1:
                rad1.setTextColor(Color.GREEN);
                TextQuestions.setText("Answer 1 is correct");
                break;
            case 2:
                rad2.setTextColor(Color.GREEN);
                TextQuestions.setText("Answer 2 is correct");
                break;
            case 3:
                rad3.setTextColor(Color.GREEN);
                TextQuestions.setText("Answer 3 is correct");
                break;
        }

        if (questionCounter < questionTotal) {
            next.setText("Next");
        } else {
            next.setText("Finish");
        }
    }
}


