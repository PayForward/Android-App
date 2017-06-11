package com.payforward.androidapp.onboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.payforward.androidapp.R;

public class VerifyMemberActivity extends AppCompatActivity {
    private ProgressBar mProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_member);
        mProgress = (ProgressBar) findViewById(R.id.progressBar5);
        mProgress.setProgress(25);
    }
    public void newActivity(View view)
    {
        Intent intent = new Intent(this, VerificationCodeActivity.class);
        startActivity(intent);
    }
}
