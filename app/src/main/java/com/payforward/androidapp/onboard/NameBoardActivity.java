package com.payforward.androidapp.onboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.payforward.androidapp.R;

public class NameBoardActivity extends AppCompatActivity {
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_board);
        progress = new ProgressBar(this);
        progress.setProgress(50);

    }
    public void newActivity(View view)
    {
        Intent intent = new Intent(this, DescriptionActivity.class);
        startActivity(intent);
    }
}
