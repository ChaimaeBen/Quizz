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

import com.example.quizz.Database.repository.userRepository;
import com.example.quizz.models.User;

import java.util.ArrayList;



public class RegisterFragment extends Fragment {
    private EditText em, first, last;
    private EditText pass, passConfirm;
    private Button btn;
private TextView goLogin;
    private userRepository mrep;
    private ArrayList<User> mUser;
    public RegisterFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        em = view.findViewById(R.id.email_id);
        first = view.findViewById(R.id.firstname);
        last = view.findViewById(R.id.lastname);
        btn = view.findViewById(R.id.log_btn);
        pass=view.findViewById(R.id.password_id);
        passConfirm=view.findViewById(R.id.password_confirm);
        mrep = new userRepository(this.getActivity().getApplication());
goLogin= view.findViewById(R.id.id_goTologin);

        goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                LoginFragment llf = new LoginFragment();
                ft.replace(R.id.frame_main, llf);
                ft.commit();
            }
        });






        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String email = em.getText().toString();
                String F1 = first.getText().toString();
                String L1 = last.getText().toString();
                String password = pass.getText().toString();
                String passwordConfirm = passConfirm.getText().toString();
                User user = new User();

                if (TextUtils.isEmpty(F1)) {
                    first.setError(getText(R.string.enter_firstname));
                } else {
                    user.setFirstname(F1);
                }
                if (TextUtils.isEmpty(L1)) {
                    last.setError(getText(R.string.enter_lastname ));
                } else {
                    user.setLastname(L1);
                }
                if (isEmail(email) == false) {
                    em.setError(getText(R.string.enter_valid_email));
                } else {
                    user.setEmail(email);
                }
                if (TextUtils.isEmpty(password)) {
                    pass.setError(getText(R.string.enter_password));
                }

                if (TextUtils.isEmpty(passwordConfirm)) {
                    passConfirm.setError(getText(R.string.confirm_password));

                    if (!passwordConfirm.matches(password)) {
                        Toast.makeText(getContext(), R.string.match_password, Toast.LENGTH_SHORT).show();
                    }

                } else {
                    user.setPassword(password);
                    user.setConfirmPassword(passwordConfirm);

                    SessionLogin session = new SessionLogin(getContext().getApplicationContext());
                    session.setLogin(true);

                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    HomeFragment llf = new HomeFragment();
                    ft.replace(R.id.frame_main, llf);
                    ft.commit();

                }

                user.setAddress("bla");
                mrep.insertUsers(user);


                first.setText("");
                last.setText("");
                pass.setText("");
                passConfirm.setText("");
                em.setText("");


            }
        });


        return view;


    }

    boolean isEmail(String t) {
        return (!TextUtils.isEmpty(t) && Patterns.EMAIL_ADDRESS.matcher(t).matches());
    }


}
