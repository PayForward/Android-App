package com.payforward.androidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class verifyMemberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_member);
    }
    public void newActivity(View view)
    {
        Intent intent = new Intent(this, verificationCodeActivity.class);
        startActivity(intent);
    }
}