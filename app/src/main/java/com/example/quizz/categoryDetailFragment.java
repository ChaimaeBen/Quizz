package com.example.quizz;

import android.app.Activity;
import android.os.Bundle;

import com.example.quizz.models.Category;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quizz.dummy.DummyContent;

/**
 * A fragment representing a single category detail screen.
 * This fragment is either contained in a {@link categoryListActivity}
 * in two-pane mode (on tablets) or a {@link categoryDetailActivity}
 * on handsets.
 */
public class categoryDetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";


    private Category mItem;


    public categoryDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {

            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.name);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.category_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.category_detail)).setText(mItem.details);
        }

        return rootView;
    }
}
