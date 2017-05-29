package com.payforward.androidapp.onboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.payforward.androidapp.R;
import com.payforward.androidapp.post.ChooseCommunityActivity;

public class WhereHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_where_home);
    }
    public void newActivity(View view)
    {
        Intent intent = new Intent(this, ChooseCommunityActivity.class);
        startActivity(intent);
    }
}
