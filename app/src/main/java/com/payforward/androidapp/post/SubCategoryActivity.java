package com.payforward.androidapp.post;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.payforward.androidapp.R;

import java.util.ArrayList;

import static com.payforward.androidapp.R.layout.subcategory;

public class SubCategoryActivity extends AppCompatActivity {

    private CustomAdapter<SubCategory> mAdapter;
    private ListView mSubCategoryList;
    private ArrayList<SubCategory> subcategoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);

        mSubCategoryList = (ListView) findViewById(R.id.subcategory_list_view);

        mSubCategoryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // mAdapter.getItem(i) gets the Category at the current position
                Toast.makeText(getApplicationContext(), mAdapter.getItem(i).getDescription(), Toast.LENGTH_SHORT).show();
            }
        });

        subcategoryList = new ArrayList<>();

        subcategoryList.add(new SubCategory("What's up?"));
        subcategoryList.add(new SubCategory("Hello!"));
        subcategoryList.add(new SubCategory("Hello2!"));
        subcategoryList.add(new SubCategory("Hello World!"));
        subcategoryList.add(new SubCategory("What's cracking?"));
        subcategoryList.add(new SubCategory("Hell no"));
        subcategoryList.add(new SubCategory("Blah!"));
        subcategoryList.add(new SubCategory("Blah Blah"));
        subcategoryList.add(new SubCategory("Blah Blah Blah"));
        subcategoryList.add(new SubCategory("Halb"));
        subcategoryList.add(new SubCategory("Halb halb"));
        subcategoryList.add(new SubCategory("Halb halb blah"));

        updateUI();
    }

    private void updateUI() {
        if (mAdapter == null) {
            mAdapter = new CustomAdapter<>(this,
                    subcategory, // What view to use for the items
                    subcategoryList); // Where to get the data
            mSubCategoryList.setAdapter(mAdapter);
        } else {
            mAdapter.clear();
            mAdapter.addAll(subcategoryList);
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
                convertView = inflater.inflate(subcategory, parent, false);
                holder.description = (TextView) convertView.findViewById(R.id.subcategory_name);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.description.setText(((SubCategory) objects.get(position)).getDescription());

            return convertView;
        }

        private class ViewHolder {
            private TextView description;
        }
    }
}
