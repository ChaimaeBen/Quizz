package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultScoreActivity extends FragmentActivity {
private Button retryButton;
    private TextView TotalScore;
    private Button quitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_score);

        Intent intent = getIntent();
        int extraScore = intent.getIntExtra("newScore",0);
        System.out.println(extraScore);
        TotalScore = findViewById(R.id.id_scoreResult);
        retryButton = findViewById(R.id.id_retryButton);
        quitButton = findViewById(R.id.id_quitButton);

        TotalScore.setText(String.valueOf((extraScore)));


        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent aa = new Intent(ResultScoreActivity.this,MainActivity.class);
                startActivity(aa);

            }
        });


        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ResultScoreActivity.this,CategoryListActivity.class);
                startActivity(intent1);
            }
        });
    }
}
