package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.quizz.Database.repository.CategoryRepository;
import com.example.quizz.Database.repository.QuestionRepository;
import com.example.quizz.models.Category;
import com.example.quizz.models.Question;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    private QuestionRepository mrep;
    private CategoryRepository crep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        mrep = new QuestionRepository(this.getApplication());
        crep = new CategoryRepository(this.getApplication());


/*

   Category c1 = new Category(0,"Film","difficulty level: easy");
        Category c2 = new Category(0,"History","difficulty level: meduim");
        Category c3 = new Category(0,"Geography","difficulty level: hard");
        Category c4 = new Category(0,"Television","difficulty level: easy");
        Category c5 = new Category(0,"Science & Nature","difficulty level: meduim");
        Category c6 = new Category(0,"Board Games","difficulty level: easy");
        Category c7 = new Category(0,"Animals","difficulty level: hard");
        Category c8 = new Category(0,"Sports","difficulty level: easy");
        Category c9 = new Category(0,"Vehicles","difficulty level: meduim");
        Category c10 = new Category(0,"Mythology","difficulty level: easy");
        Category c11= new Category(0,"Politics","difficulty level: hard");

        crep.insertCategories(c1);
        crep.insertCategories(c2);
        crep.insertCategories(c3);
        crep.insertCategories(c4);
        crep.insertCategories(c5);
        crep.insertCategories(c6);
        crep.insertCategories(c7);
        crep.insertCategories(c8);
        crep.insertCategories(c9);
        crep.insertCategories(c10);
        crep.insertCategories(c11);


        Question q1 = new Question(0,"Who played the female lead in the 1933 film King Kong?","Fay Wray","Jean Harlow","Vivien Leigh",1,1);
        Question q2 = new Question(0,"What was the name of the actor who played Leatherface in the 1974 horror film, The Texas Chainsaw Massacre?","John Dugan","Edwin Neal","Gunnar Hansen",3,1);
        Question q3 = new Question(0,"In Finding Nemo, what was the name of Nemo's mom?","Sandy","Coral","Pearl",2,1);
        Question q4 = new Question(0,"What is the species of the Predator in the 1987 movie Predator?","Yautja","Xenomorph","Phocrex",1,1);




        Question q5 = new Question(0,"What year was the United States Declaration of Independence signed?","1654","1776","1780",2,2);
        Question q6 = new Question(0,"When did Canada leave the confederation to become their own nation?","July 1st, 1867","July 1st, 1763","July 1st, 1902",1,2);
        Question q7 = new Question(0,"The idea of Socialism was articulated and advanced by whom?","Vladimir Lenin","Joseph Stalin","Karl Marx",3,2);
        Question q8 = new Question(0,"In 1453, which important city fell?","Constantinople","Rome","Athens",1,2);





        Question q9 = new Question(0,"What is the largest country in the world?","Russia","Canada","China",1,3);
        Question q10 = new Question(0,"What is the capital of Scotland?","Glasgow","Edinburgh","London",2,3);
        Question q11 = new Question(0,"Which of the following languages does NOT use the Latin alphabet?","Turkish","Georgian","Swahili",2,3);
        Question q12 = new Question(0,"What is the capital of Jamaica?","Kingston","San Juan","Bridgetown",1,3);





        Question q13 = new Question(0,"What was the name of the teenage witch played by Melisa Joan Hart who lives with her witch aunts Hilda and Zelda?","Sabrina","Sabrina","Dalia",1,4);
        Question q14 = new Question(0,"In DuckTales, what is the name of the city where all the main characters live?","Duckwing","Duckwing","Duckburg",3,4);
        Question q15 = new Question(0,"Which of these Bojack Horseman characters is a human?","Lennie Turtletaub","Princess Carolyn","Todd Chavez",3,4);




        Question q16 = new Question(0,"The medical term for the belly button is ...","Umbilicus","Nevus","Narus",1,5);
        Question q17 = new Question(0,"What is the official name of the star located closest to the North Celestial Pole?","Polaris","Eridanus","Gamma Cephei",1,5);



        Question q18 = new Question(0,"In what year was the card game Magic: the Gathering first introduced?","1953","1993","1994",2,6);
        Question q19 = new Question(0,"At the start of a standard game of the Monopoly, if you throw a double six, which square would you land on?","Electric Company","Chance Company","Water works",1,6);
        Question q20 = new Question(0,"How many dots are on a single die?","15","5","21",3,6);



        Question q21 = new Question(0,"How many legs do butterflies have?","2","3","6",3,7);
        Question q22 = new Question(0,"What colour is the female blackbird?","Brown","White","Black",1,7);
        Question q23 = new Question(0,"Which class of animals are newts members of?","Amphibian","Amphibian","Mammals",1,7);
        Question q24 = new Question(0,"What is the fastest  land animal?","Lion","Tiger","Cheetah",3,7);
        Question q25 = new Question(0,"What is Grumpy Cat's real name?","Tardar Sauce","Ketchup","Lili",1,7);



        Question q26 = new Question(0,"What is the most common type of pitch thrown by pitchers in baseball?","Tardar Sauce","Ketchup","Lili",1,8);
        Question q27 = new Question(0,"Which African American is in part responsible for integrating  Major League baseball?","Curt Flood","Satchell Paige","Jackie Robinson",3,8);


        Question q28 = new Question(0,"What is the name of Nissan's most popular electric car?","Leaf","Dear","Roots",1,9);
        Question q29 = new Question(0,"Which car tire manufacturer is famous for its P Zero line?","Pirelli","Goodyear","Michelllin",1,9);


            Question q30 = new Question(0,"In Greek mythology, who is the god of wine?","Zeus","Apollo","Dionysus",3,10);
        Question q31 = new Question(0,"The Nike apparel and footwear brand takes it's name from the Greek goddess of what?","Honor","Courage","Victory",3,10);


        Question q32 = new Question(0,"Who was the 45th President of the United States?","Barack Obama","Barack Obama","Donald Trump",3,11);
        Question q33 = new Question(0,"Which Native American tribe nation requires at least one half blood quantum (equivalent to one parent) to be eligible for membership?","Yomba Shoshone Tribe","Pawnee Nation of Oklahoma","Kiowa Tribe of Oklahoma",1,11);



        mrep.insert(q1);
        mrep.insert(q2);
        mrep.insert(q3);
        mrep.insert(q4);
        mrep.insert(q5);
        mrep.insert(q6);
        mrep.insert(q7);
        mrep.insert(q8);
        mrep.insert(q9);
        mrep.insert(q10);
        mrep.insert(q11);
        mrep.insert(q12);
        mrep.insert(q13);
        mrep.insert(q14);
        mrep.insert(q15);
        mrep.insert(q16);
        mrep.insert(q17);
        mrep.insert(q18);
        mrep.insert(q19);
        mrep.insert(q20);
        mrep.insert(q21);
        mrep.insert(q22);
        mrep.insert(q23);
        mrep.insert(q24);
        mrep.insert(q25);
        mrep.insert(q26);
        mrep.insert(q27);
        mrep.insert(q28);
        mrep.insert(q29);
        mrep.insert(q30);
        mrep.insert(q31);
        mrep.insert(q32);
        mrep.insert(q33);
*/


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.searchlogobigger);

        if (findViewById(R.id.frame_main) != null) {
            if (savedInstanceState != null) {
                return;
            }
            fragmentManager.beginTransaction().add(R.id.frame_main, new LoginFragment()).commit();
        }



    }@Override
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
                         at.replace(R.id.frame_main, az);
                         at.commit();
                return true;
            case R.id.profileItem:
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ProfileFragment llf = new ProfileFragment();
                ft.replace(R.id.frame_main, llf);
                ft.commit();
                return true;
            case R.id.homeItem:

                FragmentTransaction ar = fragmentManager.beginTransaction();
                HomeFragment tt = new HomeFragment();
                ar.replace(R.id.frame_main, tt);
                ar.commit();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
