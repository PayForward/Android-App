package com.payforward.androidapp.onboard;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.payforward.androidapp.R;

public class DescriptionActivity extends AppCompatActivity {

    private ProgressBar mProgress;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        mProgress = (ProgressBar) findViewById(R.id.progressBar8);
        mProgress.setProgress(40);
        int charcounter = 250;
        tv = (TextView)findViewById(R.id.counter);
        tv.setText(String.format(Integer.toString(charcounter)));
    }
    public void newActivity(View view)
    {
        Intent intent = new Intent(this, UploadPhotoActivity.class);
        startActivity(intent);
    }
}
