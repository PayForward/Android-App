package com.payforward.androidapp.post;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.payforward.androidapp.R;

import java.util.ArrayList;
import java.util.Map;

import static com.payforward.androidapp.R.layout.subcategory;

public class SubCategoryActivity extends AppCompatActivity {

    private CustomAdapter<SubCategory> mAdapter;
    private ListView mSubCategoryList;
    private ArrayList<SubCategory> subcategoryList;
    private DatabaseReference mDatabase;
    private final String TAG = "SubCategoryActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mSubCategoryList = (ListView) findViewById(R.id.subcategory_list_view);

        mSubCategoryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // mAdapter.getItem(i) gets the Category at the current position
                Toast.makeText(getApplicationContext(), mAdapter.getItem(i).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        subcategoryList = new ArrayList<>();
        DatabaseReference ref = mDatabase.child("subcategories");

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    subcategoryList.add(new SubCategory((String) snapshot.getValue()));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(TAG, "Something went wrong");
            }
        });

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
                holder.title = (TextView) convertView.findViewById(R.id.subcategory_name);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.title.setText(((SubCategory) objects.get(position)).getTitle());

            return convertView;
        }

        private class ViewHolder {
            private TextView title;
        }
    }
}