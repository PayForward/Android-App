package com.payforward.androidapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import static android.R.id.progress;

public class NameBoardActivity extends AppCompatActivity {
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_board);
        progress = new ProgressDialog(this);
        progress.setProgress(50);

    }
    public void newActivity(View view)
    {
        Intent intent = new Intent(this, DescriptionActivity.class);
        startActivity(intent);
    }
}
