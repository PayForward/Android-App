package com.payforward.androidapp.onboard;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.payforward.androidapp.R;

public class DescriptionActivity extends AppCompatActivity {

    private ProgressBar mProgress;
    private TextInputLayout value;
//    private EditText edittext;
//    private View v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        mProgress = (ProgressBar) findViewById(R.id.progressBar8);
        mProgress.setProgress(40);
//        edittext = (EditText)findViewById(R.id.desc);
        value = (TextInputLayout)findViewById(R.id.textInputLayout);
    }
//    public void setupFloatingLabelError(){
//        final TextInputLayout floating = (TextInputLayout)findViewById(R.id.textInputLayout);
//        floating.getEditText().addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                if(s.length() > 20){
//                    CharSequence text = "You have overwritten amount of chars";
//                    Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    newActivity(v);
//                    startActivity(new Intent(DescriptionActivity.this, UploadPhotoActivity.class));
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//    }
    public void newActivity(View view)
    {
        int length = value.getEditText().length();
        if(length > 500){
            CharSequence text = "You have overwritten amount of chars";
            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(this, UploadPhotoActivity.class);
            startActivity(intent);
        }
    }
}
