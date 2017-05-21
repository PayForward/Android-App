package com.payforward.androidapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class termsActivity extends AppCompatActivity {
    private ProgressDialog progress;
    private Button accept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);
        progress = new ProgressDialog(this);
        progress.setProgress(10);
        accept = (Button) findViewById(R.id.acceptance);
        Intent i = getIntent();
        accept.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        newActivity(v);
                    }
                }
        );
    }

    public void newActivity(View view)
    {
        Intent intent = new Intent(this, createAccountActivity.class);
        startActivity(intent);
    }
}
