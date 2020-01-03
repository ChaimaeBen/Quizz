package com.example.quizz.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.quizz.Database.repository.userRepository;
import com.example.quizz.models.User;

public class UserViewModel extends AndroidViewModel {

    private userRepository rep;

    public UserViewModel(@NonNull Application application) {
        super(application);
        rep = new userRepository(application);

    }
    public void insert(User users){
        rep.insertUsers(users);
    }



}