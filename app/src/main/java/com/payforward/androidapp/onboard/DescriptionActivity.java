package com.payforward.androidapp.onboard;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.payforward.androidapp.R;

public class DescriptionActivity extends AppCompatActivity {

    private ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        progress = new ProgressDialog(this);
        progress.setProgress(50);
    }
    public void newActivity(View view)
    {
        Intent intent = new Intent(this, UploadPhotoActivity.class);
        startActivity(intent);
    }
}
