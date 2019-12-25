package com.example.quizz.Database.repository;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.quizz.Database.dao.QuestionDao;
import com.example.quizz.models.Question;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class QuestionRepository {

    private QuestionDao mQuestionDao;
private List<Question> mAllQuestions;
private  List<Question> mCategories;
    private AppDatabase myDb;

    public QuestionRepository(Application application) {
        myDb = AppDatabase.getDatabase(application);
        mQuestionDao = myDb.questionDao();
        mAllQuestions = mQuestionDao.getAll();;

    }


     public void insert( Question questions) {
        System.out.println("entered insert");

        AppDatabase.databaseWriteExecutor.execute(()
    ->{mQuestionDao.insert(questions);});
    }

public List<Question> getCategories(int categories){
        AppDatabase.databaseWriteExecutor.execute(()->{
            mCategories = mQuestionDao.getQuestionsWithCategory(categories);});
      return mCategories;


    }

    public List<Question> getAllQuestions(){
        return mAllQuestions;
   }

   /*
    public void DeleteAllQuestions( List<Question>questions){
         mAllQuestions.removeAll(questions);
    }
*/
}


