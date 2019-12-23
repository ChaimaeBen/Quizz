package com.example.quizz;

import android.content.Context;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;

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

import com.example.quizz.Database.repository.QuestionRepository;
import com.example.quizz.models.Question;

import java.util.List;


public class DetailCategoryFragment extends Fragment {
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
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_detail_category, container, false);

        return view;
    }
}
