package com.payforward.androidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SignUpTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_type);
    }

    public void nextScreen(View view) {
        Intent intent = new Intent(this, SignUpNameActivity.class);
        startActivity(intent);
    }
}
