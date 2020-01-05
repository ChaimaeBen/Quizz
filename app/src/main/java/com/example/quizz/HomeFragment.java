package com.example.quizz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.quizz.CategoryListActivity;
import com.example.quizz.MainActivity;
import com.example.quizz.QuestionActivity;
import com.example.quizz.R;

public class HomeFragment extends Fragment {
    private Button startButton;
    private Button catButton;

    View view;

    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        startButton = view.findViewById(R.id.id_startButton);
        catButton = view.findViewById(R.id.id_categoryButton);
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();

        catButton.setOnClickListener((View v) -> {
            DirectToCategory();
        });
        startButton.setOnClickListener((View v) -> {
            DirectToQuiz();
        });

        return view;

    }





    private void DirectToQuiz(){
        Intent intent = new Intent(getContext(), QuestionActivity.class);
        startActivity(intent);
    }

    private void DirectToCategory(){
        Intent intent = new Intent(getContext(), CategoryListActivity.class);
        startActivity(intent);
    }
}
