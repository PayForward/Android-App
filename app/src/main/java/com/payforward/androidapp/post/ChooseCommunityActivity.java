package com.payforward.androidapp.post;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.payforward.androidapp.R;
import com.payforward.androidapp.onboard.TermsActivity;

import java.util.ArrayList;
import java.util.Map;

import static com.payforward.androidapp.R.layout.community;

public class ChooseCommunityActivity extends AppCompatActivity {
    private ProgressBar mProgress;
    private CustomAdapter<Community> mAdapter;
    private ListView mCommunityList;
    private ArrayList<Community> communityList;
    private DatabaseReference mDatabase;
//    private final String TAG = "ChooseCommunityActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_community);
        mProgress = (ProgressBar) findViewById(R.id.progressBar2);
        mProgress.setProgress(10);
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        StorageReference imagesRef = storageRef.child("categories");
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mCommunityList = (ListView) findViewById(R.id.community_list_view);

//        mCommunityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                // mAdapter.getItem(i) gets the Category at the current position
//                startActivity(new Intent(ChooseCommunityActivity.this, TermsActivity.class));
//            }
//        });
        communityList = new ArrayList<>();
        DatabaseReference ref = mDatabase.child("communities");

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Map<String, Object> newCommunity = (Map<String, Object>) snapshot.getValue();
                    communityList.add(new Community((String) newCommunity.get("name"), ((Long)newCommunity.get("memberCount")).intValue(), (String) newCommunity.get("description")));
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
    public void newActivity(View view)
    {
        Intent intent = new Intent(this, TermsActivity.class);
        startActivity(intent);
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
                convertView = inflater.inflate(community, parent, false);
                holder.title = (TextView) convertView.findViewById(R.id.title);
                holder.comDesc = (TextView) convertView.findViewById(R.id.com_desc);
                holder.comSubDesc = (TextView) convertView.findViewById(R.id.com_sub_desc);
                holder.image = (ImageView) convertView.findViewById(R.id.image);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.title.setText(((Community) objects.get(position)).getTitle());
            int numMembers = ((Community) objects.get(position)).getNumberMembers();
            String subd = "Public Group with " + Integer.toString(numMembers) + " Members";
            holder.comSubDesc.setText(subd);
            holder.comDesc.setText(((Community) objects.get(position)).getCommunityDescription());
            holder.image.setImageDrawable(((Community) objects.get(position)).getImage());

            return convertView;
        }

        private class ViewHolder {
            private TextView title, comDesc, comSubDesc;
            private ImageView image;
        }
    }
}
