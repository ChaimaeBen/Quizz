package com.example.quizz;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import com.example.quizz.Database.repository.CategoryRepository;
import com.example.quizz.Database.repository.QuestionRepository;
import com.example.quizz.models.Category;
import com.example.quizz.models.Question;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizz.dummy.DummyContent;

import java.util.List;

/**
 * A fragment representing a single Category detail screen.
 * This fragment is either contained in a {@link CategoryListActivity}
 * in two-pane mode (on tablets) or a {@link CategoryDetailActivity}
 * on handsets.
 */
public class CategoryDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";
    public static final String display_score = "newScore";

    /**
     * The dummy content this fragment is presenting.
     */

    View rootView;
    private Category mItem;
    private QuestionRepository mrep;
    private CategoryRepository crep;
    private TextView TextQuestions, TextScore,TextCount,TextTime,Textcategory;
    private RadioGroup group;
    private RadioButton rad1, rad2, rad3;
    private Question current;
    private Button next;
    private int score;
    private boolean answer;
    private List<Question> mQuestions;
    private int questionCounter;
    private int questionTotal;
    private ColorStateList textDefaultColor;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CategoryDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.category_name);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         rootView = inflater.inflate(R.layout.category_detail, container, false);


        next = rootView.findViewById(R.id.detail_next);
        TextQuestions =rootView.findViewById(R.id.detail_question);
        TextScore=rootView.findViewById(R.id.detail_totalText);
        TextCount=rootView.findViewById(R.id.detail_questionCount);
        group = rootView.findViewById(R.id.radioDetailGroup);
        rad1 = rootView.findViewById(R.id.detail_radio1);
        rad2 = rootView.findViewById(R.id.detail_radio2);
        rad3 = rootView.findViewById(R.id.detail_radio3);

        textDefaultColor = rad3.getTextColors();

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.category_detail)).setText(mItem.category_details);
        }

          System.out.println(mItem.category_name);

        mrep = new QuestionRepository(this.getActivity().getApplication());
        crep = new CategoryRepository(this.getActivity().getApplication());

        mQuestions= mrep.getCategories(mItem.getCategory_id());

        questionTotal = mQuestions.size();

        showNextQuestion();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!answer){
                    if(rad1.isChecked()||rad2.isChecked()||rad3.isChecked()){
                        AnswerChecker();
                    }else {
                        Toast.makeText(getContext(), "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    showNextQuestion();
                }
            }

        });


        return rootView;
    }
    private void AnswerChecker(){
        answer = true;

        RadioButton select = rootView.findViewById(group.getCheckedRadioButtonId());
        int number = group.indexOfChild(select)+1;

        if(number == current.getAnswer_number()){
            score++;
            TextScore.setText("Score: " +score);
        }
        showSolution();
    }

    private void showNextQuestion(){
        rad1.setTextColor(textDefaultColor);
        rad2.setTextColor(textDefaultColor);
        rad3.setTextColor(textDefaultColor);
        group.clearCheck();

        if(questionCounter<questionTotal) {
            current = mQuestions.get(questionCounter);

            TextQuestions.setText(current.getQuestion());
            rad1.setText(current.getChoice1());
            rad2.setText(current.getChoice2());
            rad3.setText(current.getChoice3());

            questionCounter++;
            TextCount.setText("Question: " + questionCounter + "/" + questionTotal);
            answer = false;
            next.setText("confirm");
        }else{
            endQuiz();

        }}


    private void endQuiz(){
        Intent intent= new Intent(getActivity(), ResultScoreActivity.class);
        intent.putExtra("newScore",score);
        startActivity(intent);
    }



    private void showSolution() {
        rad2.setTextColor(Color.RED);
        rad1.setTextColor(Color.RED);
        rad3.setTextColor(Color.RED);

        switch (current.getAnswer_number()) {
            case 1:
                rad1.setTextColor(Color.GREEN);
                TextQuestions.setText("Answer 1 is correct");
                break;
            case 2:
                rad2.setTextColor(Color.GREEN);
                TextQuestions.setText("Answer 2 is correct");
                break;
            case 3:
                rad3.setTextColor(Color.GREEN);
                TextQuestions.setText("Answer 3 is correct");
                break;
        }

        if (questionCounter < questionTotal) {
            next.setText("Next");
        } else {
            next.setText("Finish");
        }
    }
}
