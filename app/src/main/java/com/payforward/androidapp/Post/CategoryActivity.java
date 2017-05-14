package com.payforward.androidapp.Post;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.payforward.androidapp.R;

import java.util.ArrayList;

import static com.payforward.androidapp.R.layout.category;

public class CategoryActivity extends AppCompatActivity {

    private CustomAdapter mAdapter;
    private ListView mTaskListView;
    private ArrayList<Category> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        mTaskListView = (ListView) findViewById(R.id.category_list_view);
        categoryList = new ArrayList<>();

        categoryList.add(new Category("What's up?", "Blah Blah"));
        categoryList.add(new Category("Hello!", "This is a description"));
        categoryList.add(new Category("Hello!", "This is a description 2"));
        categoryList.add(new Category("Hello World!", "This is a description"));
        categoryList.add(new Category("What's up?", "Blah Blah"));
        categoryList.add(new Category("Hello!", "This is a description"));
        categoryList.add(new Category("Hello!", "This is a description 2"));
        categoryList.add(new Category("Hello World!", "This is a description"));
        categoryList.add(new Category("What's up?", "Blah Blah"));
        categoryList.add(new Category("Hello!", "This is a description"));
        categoryList.add(new Category("Hello!", "This is a description 2"));
        categoryList.add(new Category("Hello World!", "This is a description"));

        for (Category category : categoryList) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                category.setImage(getDrawable(R.drawable.art_category));
            }
        }

        updateUI();
    }

    private void updateUI() {
        if (mAdapter == null) {
            mAdapter = new CustomAdapter<>(this,
                    category, // What view to use for the items
                    categoryList); // Where to get the data
            mTaskListView.setAdapter(mAdapter);
        } else {
            mAdapter.clear();
            mAdapter.addAll(categoryList);
            mAdapter.notifyDataSetChanged();
        }
    }

    private class CustomAdapter<T> extends ArrayAdapter<T> {
        // Instance variable
        ArrayList<T> objects;
        LayoutInflater inflater;

        // Constructor
        private CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<T> objects) {
            super(context, resource, objects);
            inflater = LayoutInflater.from(context);
            this.objects = objects;
        }

        @Override
        @NonNull
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = inflater.inflate(category, parent, false);
                holder.description = (TextView) convertView.findViewById(R.id.category_name);
                holder.helper = (TextView) convertView.findViewById(R.id.category_helper);
                holder.image = (ImageView) convertView.findViewById(R.id.artImage);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.description.setText(((Category) objects.get(position)).getDescription());
            holder.helper.setText(((Category) objects.get(position)).getHelper());
            holder.image.setImageDrawable(((Category) objects.get(position)).getImage());

            return convertView;
        }

        private class ViewHolder {
            private TextView description, helper;
            private ImageView image;
        }
    }
}
