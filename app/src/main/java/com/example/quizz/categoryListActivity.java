package com.example.quizz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import com.example.quizz.Database.repository.CategoryRepository;
import com.example.quizz.models.Category;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quizz.dummy.DummyContent;

import java.util.List;

public class categoryListActivity extends AppCompatActivity {

    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

          if (findViewById(R.id.fragment4) != null) {

            mTwoPane = true;
        }

        View recyclerView = findViewById(R.id.category_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(this, DummyContent.ITEMS, mTwoPane));
    }

    public static class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final categoryListActivity mParentActivity;
        private final List<Category> mValues;
        private final boolean mTwoPane;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Category item = (Category) view.getTag();




                if (mTwoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putString(categoryDetailFragment.ARG_ITEM_ID, String.valueOf(item.getCategory_id()));
                    arguments.putString("Key",String.valueOf(item.getCategory_name()));
                    categoryDetailFragment fragment = new categoryDetailFragment();
                    fragment.setArguments(arguments);
                    mParentActivity.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment4, fragment)
                            .commit();
                } else {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, categoryDetailActivity.class);
                    intent.putExtra(categoryDetailFragment.ARG_ITEM_ID, String.valueOf(item.getCategory_id()));
                            context.startActivity(intent);
                }
            }
        };

        SimpleItemRecyclerViewAdapter(categoryListActivity parent,
                                      List<Category> items,
                                      boolean twoPane) {
            mValues = items;
            mParentActivity = parent;
            mTwoPane = twoPane;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.category_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mContentView.setText(mValues.get(position).category_name);

            holder.itemView.setTag(mValues.get(position));
            holder.itemView.setOnClickListener(mOnClickListener);
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final TextView mContentView;

            ViewHolder(View view) {
                super(view);
                mContentView = (TextView) view.findViewById(R.id.content);
            }
        }
    }
}
