package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
    public static FragmentManager fragmentManager;

    User user = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);
        fragmentManager = getSupportFragmentManager();


        rep = new userRepository(this.getApplication());

listview = findViewById(R.id.leader_list);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.searchlogobigger);

        List <User> users = rep.getAllScores();


        final ArrayList<String> list = new ArrayList<String>();

        for (User user : users) {
            list.add(users.indexOf(user) +"    " +"user:   "+user.getFirstname() +"        "+ "Score:  " + user.getNewHigh());}
        ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list);


        listview.setAdapter(adapter);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main_menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.rankingItem:
                Intent intent = new Intent(getApplicationContext(), LeaderBoardActivity.class);
                startActivity(intent);


                return true;
            case R.id.logout:
                SessionLogin session = new SessionLogin(this.getApplicationContext());
                session.setLogin(false);

                SharedPreferences sh= getSharedPreferences("MySharedPref",MODE_PRIVATE);
                SharedPreferences.Editor editor = sh.edit();
                editor.remove("email");

                editor.apply();

                FragmentTransaction at = fragmentManager.beginTransaction();
                LoginFragment az = new LoginFragment();
                at.replace(R.id.id_frameConst, az);
                at.commit();
                return true;
            case R.id.profileItem:
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ProfileFragment llf = new ProfileFragment();
                ft.replace(R.id.id_frameConst, llf);
                ft.commit();
                return true;
            case R.id.homeItem:

                FragmentTransaction ar = fragmentManager.beginTransaction();
                HomeFragment tt = new HomeFragment();
                ar.replace(R.id.id_frameConst, tt);
                ar.commit();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}


