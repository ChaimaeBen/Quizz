package com.example.quizz;

import android.content.Context;
import android.content.res.ColorStateList;
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

import com.example.quizz.Database.repository.QuestionRepository;
import com.example.quizz.models.Question;

import java.util.Collections;
import java.util.List;


public class DetailCategoryFragment extends Fragment {

    View view;

    private TextView TextQuestions, TextScore,TextCount,TextTime;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_detail_category, container, false);

      TextQuestions =view.findViewById(R.id.detail_question);
     TextQuestions.setText("modified question");

        return view;
    }
}
