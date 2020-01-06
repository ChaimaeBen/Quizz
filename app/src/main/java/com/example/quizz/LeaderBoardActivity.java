package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;

import com.example.quizz.Database.repository.userRepository;
import com.example.quizz.models.User;

import java.util.ArrayList;
import java.util.List;

public class LeaderBoardActivity extends AppCompatActivity {
    private ListView listview;
    private userRepository rep;
User user = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);


        rep = new userRepository(this.getApplication());

listview = findViewById(R.id.leader_list);


        List <User> users = rep.getAllScores();


        final ArrayList<String> list = new ArrayList<String>();

        for (User user : users) {
            list.add(users.indexOf(user) +"   " +"user: "+user.getFirstname() +"       "+ "Score: " + user.getNewHigh());}
        ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list);


        listview.setAdapter(adapter);


    }


}
