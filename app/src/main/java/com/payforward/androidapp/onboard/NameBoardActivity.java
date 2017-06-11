package com.payforward.androidapp.onboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.payforward.androidapp.R;

public class NameBoardActivity extends AppCompatActivity {
    private ProgressBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_board);
        mProgress = (ProgressBar) findViewById(R.id.progressBar7);
        mProgress.setProgress(35);

    }
    public void newActivity(View view)
    {
        Intent intent = new Intent(this, DescriptionActivity.class);
        startActivity(intent);
    }
}
