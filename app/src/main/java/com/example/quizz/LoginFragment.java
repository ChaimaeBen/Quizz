package com.example.quizz;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizz.Database.dao.UserDao;
import com.example.quizz.Database.repository.userRepository;
import com.example.quizz.models.User;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 */
public class LoginFragment extends Fragment {
    private UserDao dao;
    private EditText em, pass;
    private Button btn;
private TextView txtCreate;
    private userRepository mrep;
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);



        txtCreate = v.findViewById(R.id.id_creatTxt);
        em = v.findViewById(R.id.email_id);
        pass = v.findViewById(R.id.password_id);
        btn = v.findViewById(R.id.log_btn);
        mrep = new userRepository(this.getActivity().getApplication());



        txtCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                RegisterFragment llf = new RegisterFragment();
                ft.replace(R.id.frame_main, llf);
                ft.commit();
            }
        });




        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                User u = new User();
                String email = em.getText().toString();
                String pa = pass.getText().toString();

                if (!isEmail(email)) {
                    em.setError(getText(R.string.enter_valid_email));
                }else{
                    u.setEmail(email);
                }
                if (TextUtils.isEmpty(pa)) {
                    pass.setError(getText(R.string.enter_password));

                }else{u.setPassword(pa);}


                if (mrep.verify(email, pa)!=null) {
                    SessionLogin session = new SessionLogin(getContext().getApplicationContext());
                    session.setLogin(true);

                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    HomeFragment llf = new HomeFragment();
                    ft.replace(R.id.frame_main, llf);
                    ft.commit();
                } else {
                    Toast.makeText(getContext(), R.string.incorrect, Toast.LENGTH_SHORT).show();

                }
                em.setText("");
                pass.setText("");
            }



//https://stackoverflow.com/questions/21228721/how-to-replace-a-fragment-on-button-click-of-that-fragm
        });

        return v;


    }
    boolean isEmail(String t) {
        return (!TextUtils.isEmpty(t) && Patterns.EMAIL_ADDRESS.matcher(t).matches());
    }
}



