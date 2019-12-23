package com.example.quizz.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.quizz.Database.repository.AppDatabase;
import com.example.quizz.Database.repository.QuestionRepository;
import com.example.quizz.models.Question;

import java.util.List;

public class QuestionViewModel extends AndroidViewModel {

    private QuestionRepository mRep;
    private List<Question>mAll;

    public QuestionViewModel(Application application){
        super(application);
        mRep = new QuestionRepository(application);
        mAll = mRep.getAllQuestions();
    }

   List<Question> getAllQuestions(){
        return mAll;
    }
    public void insert(Question question){
        mRep.insert(question);
    }
}
