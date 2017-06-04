package com.payforward.androidapp.post;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.payforward.androidapp.R;

public class DescribeOfferActivity extends AppCompatActivity {
    private ProgressBar mProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_describe_offer);
        mProgress = (ProgressBar) findViewById(R.id.progressBar11);
        mProgress.setProgress(65);
    }
}
