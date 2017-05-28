package com.payforward.androidapp.onboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.payforward.androidapp.R;

public class PreviewScreensActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previewscreens);

        if (savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.preview_fragment, IntroPageFragment.newInstance(), "Firstprevfrag")
                    .commit();
        }
    }
}
