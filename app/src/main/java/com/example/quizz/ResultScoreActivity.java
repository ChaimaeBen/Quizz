package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultScoreActivity extends FragmentActivity {
private Button retryButton;
    private TextView TotalScore;
    private TextView HighText;
    private Button quitButton;
    private int highscore;
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
        HighText = findViewById(R.id.id_highestScore);

        TotalScore.setText(String.valueOf((extraScore)));
        setHigh();

        if(extraScore>highscore) {
            updateHighscore(extraScore);
        }

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

    private void setHigh() {
        SharedPreferences prefs = getSharedPreferences("highPref", MODE_PRIVATE);
        highscore = prefs.getInt("highKey", 0);
        HighText.setText(String.valueOf(highscore));
    }

    private void updateHighscore(int highscoreNew) {
        highscore = highscoreNew;
        HighText.setText(String.valueOf(highscore));

        SharedPreferences prefs = getSharedPreferences("highPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("highKey", highscore);
        editor.apply();
    }
}

