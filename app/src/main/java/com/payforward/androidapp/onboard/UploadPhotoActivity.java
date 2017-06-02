package com.payforward.androidapp.onboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.payforward.androidapp.R;
import com.payforward.androidapp.post.CategoryActivity;

public class UploadPhotoActivity extends AppCompatActivity {
    private ProgressBar mProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_photo);
        mProgress = (ProgressBar) findViewById(R.id.progressBar9);
        mProgress.setProgress(45);
    }
    public void newActivity(View view)
    {
        Intent intent = new Intent(this, CategoryActivity.class);
        startActivity(intent);
    }
}
