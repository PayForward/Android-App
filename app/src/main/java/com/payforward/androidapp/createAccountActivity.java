package com.payforward.androidapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class createAccountActivity extends AppCompatActivity {
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        progress = new ProgressDialog(this);
        progress.setProgress(10);
    }
    public void newActivity(View view)
    {
        Intent intent = new Intent(this, verifyMemberActivity.class);
        startActivity(intent);
    }
}
