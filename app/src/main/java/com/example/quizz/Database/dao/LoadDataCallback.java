package com.example.quizz.Database.dao;

import java.util.List;

public interface LoadDataCallback<T> {
    void onDataLoaded(List<T> data);
}
