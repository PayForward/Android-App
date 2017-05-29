package com.payforward.androidapp.post;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.payforward.androidapp.R;
import com.payforward.androidapp.termsActivity;

import java.util.ArrayList;
import java.util.Map;

import static com.payforward.androidapp.R.layout.category;
import static com.payforward.androidapp.R.layout.community;

public class ChooseCommunityActivity extends AppCompatActivity {

    private CustomAdapter<Community> mAdapter;
    private ListView mCommunityList;
    private ArrayList<Community> communityList;
    private DatabaseReference mDatabase;
    private final String TAG = "ChooseCommunityActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_community);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mCommunityList = (ListView) findViewById(R.id.community_list_view);

        mCommunityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // mAdapter.getItem(i) gets the Category at the current position
                startActivity(new Intent(ChooseCommunityActivity.this, termsActivity.class));
            }
        });
        communityList = new ArrayList<>();
        DatabaseReference ref = mDatabase.child("communities");

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Map<String, Object> newCommunity = (Map<String, Object>) snapshot.getValue();
                    communityList.add(new Community((String) newCommunity.get("name"), (int) newCommunity.get("memberCount"), (String) newCommunity.get("description")));
                }
                updateUI();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void updateUI() {
        if (mAdapter == null) {
            mAdapter = new CustomAdapter<>(this,
                    community, // What view to use for the items
                    communityList); // Where to get the data
            mCommunityList.setAdapter(mAdapter);
        } else {
            mAdapter.clear();
            mAdapter.addAll(communityList);
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
            CategoryActivity.CustomAdapter.ViewHolder holder;
            if (convertView == null) {
                holder = new CategoryActivity.CustomAdapter.ViewHolder();
                convertView = inflater.inflate(category, parent, false);
                holder.title = (TextView) convertView.findViewById(R.id.title);
                holder.subTitle = (TextView) convertView.findViewById(R.id.subTitle);
                holder.image = (ImageView) convertView.findViewById(R.id.image);
                convertView.setTag(holder);
            } else {
                holder = (CategoryActivity.CustomAdapter.ViewHolder) convertView.getTag();
            }
            holder.title.setText(((Category) objects.get(position)).getTitle());
            holder.subTitle.setText(((Category) objects.get(position)).getSubTitle());
            holder.image.setImageDrawable(((Category) objects.get(position)).getImage());

            return convertView;
        }

        private class ViewHolder {
            private TextView title, subTitle;
            private ImageView image;
        }
    }
}
