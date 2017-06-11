package com.payforward.androidapp.post;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.payforward.androidapp.R;
import com.payforward.androidapp.onboard.DescriptionActivity;

public class offerTitleActivity extends AppCompatActivity {
    private ProgressBar mProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_title);
        mProgress = (ProgressBar) findViewById(R.id.progressBar10);
        mProgress.setProgress(60);
    }
    public void newActivity(View view)
    {
        Intent intent = new Intent(this, DescriptionActivity.class);
        startActivity(intent);
    }
}
