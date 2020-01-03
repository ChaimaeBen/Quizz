package com.example.quizz.models;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "Question",
        foreignKeys = {@ForeignKey(
                entity = Category.class,
                childColumns = "category_id",
                parentColumns = "category_id"
        ,onUpdate = ForeignKey.CASCADE,
        onDelete = ForeignKey.CASCADE)})

public class Question {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "question_id",index = true)
    private int question_id;
    @ColumnInfo(name = "question")
    private String question;
    @ColumnInfo(name = "category_id",index = true)
    private int category_id;
    @ColumnInfo(name = "choice1")
    private String choice1;
    @ColumnInfo(name = "choice2")
    private String choice2;
    @ColumnInfo(name = "choice3")
    private String choice3;
    @ColumnInfo(name = "answer_number")
    private int answer_number;


    public Question(int question_id, String question, String choice1, String choice2, String choice3, int answer_number,int category_id) {
        this.question_id = question_id;
        this.question = question;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.answer_number = answer_number;
        this.category_id = category_id;

    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Ignore
    public Question() {

    }


    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public int getAnswer_number() {
        return answer_number;
    }

    public void setAnswer_number(int answer_number) {
        this.answer_number = answer_number;
    }
}
