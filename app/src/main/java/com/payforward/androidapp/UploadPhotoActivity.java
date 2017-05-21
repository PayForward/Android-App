package com.payforward.androidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.payforward.androidapp.post.CategoryActivity;

public class UploadPhotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_photo);
    }
    public void newActivity(View view)
    {
//        Intent intent = new Intent(this, CategoryActivity.class);
//        startActivity(intent);
    }
}
