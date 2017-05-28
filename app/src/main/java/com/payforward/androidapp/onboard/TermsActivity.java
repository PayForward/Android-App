package com.payforward.androidapp.onboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.payforward.androidapp.R;

public class TermsActivity extends AppCompatActivity {
    private ProgressBar progress;
    private Button accept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);
        progress = new ProgressBar(this);
        progress.setProgress(10);
        accept = (Button) findViewById(R.id.acceptance);
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
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }
}
