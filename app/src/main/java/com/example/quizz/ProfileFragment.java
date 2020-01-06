package com.example.quizz;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quizz.Database.repository.userRepository;
import com.example.quizz.models.User;

import static android.content.Context.MODE_PRIVATE;


public class ProfileFragment extends Fragment {

private TextView first,email,last,high;
    userRepository rep;
private User u;
    public ProfileFragment() {
        // Required empty public constructor
    }


     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         rep = new userRepository(getActivity().getApplication());

        SharedPreferences A= getActivity().getSharedPreferences("MySharedPref",MODE_PRIVATE);
         SharedPreferences Az= getActivity().getSharedPreferences("highPref",MODE_PRIVATE);

        View view= inflater.inflate(R.layout.fragment_profile, container, false);
        String em = A.getString("email", "");
int highscore=Az.getInt("highKey",0);

u = rep.getUserEmail(em);
    String fi= u.getFirstname();
   String ls=  u.getLastname();

         first = view.findViewById(R.id.id_firstname);
        email = view.findViewById(R.id.id_email);
        last = view.findViewById(R.id.id_lastname);
     high = view.findViewById(R.id.id_high);
System.out.print(fi);
         System.out.print(ls);
        email.setText(em);
        first.setText(fi);
      last.setText(ls);
      high.setText(String.valueOf(highscore));
        return  view;
    }


}
