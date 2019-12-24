package com.example.quizz;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizz.Database.repository.QuestionRepository;
import com.example.quizz.models.Question;

import java.util.Collections;
import java.util.List;


public class DetailCategoryFragment extends Fragment {

    View view;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_detail_category, container, false);

        next = view.findViewById(R.id.detail_next);
        TextQuestions =view.findViewById(R.id.detail_question);
        TextScore=view.findViewById(R.id.detail_totalText);
        TextTime=view.findViewById(R.id.detail_countdown);
        TextCount=view.findViewById(R.id.detail_questionCount);
        group = view.findViewById(R.id.radioDetailGroup);
        rad1 = view.findViewById(R.id.detail_radio1);
        rad2 = view.findViewById(R.id.detail_radio2);
        rad3 = view.findViewById(R.id.detail_radio3);

        textDefaultColor = rad3.getTextColors();

        mrep = new QuestionRepository(this.getActivity().getApplication());

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
                        Toast.makeText(getContext(), "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    showNextQuestion();
                }
            }

        });


        return view;
    }



    private void AnswerChecker(){
        answer = true;

        RadioButton select = view.findViewById(group.getCheckedRadioButtonId());
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
        getActivity().finish();
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



