package com.payforward.androidapp.onboard;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.payforward.androidapp.R;

public class CreateAccountActivity extends AppCompatActivity {
    private ProgressDialog progress;
    private EditText mEmail;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        // Set progress bar
        progress = new ProgressDialog(this);
        progress.setProgress(10);

        mEmail = (EditText) findViewById(R.id.email);
        mPassword = (EditText) findViewById(R.id.password);

        mPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.fab || id == EditorInfo.IME_NULL) {
                    attemptProceed();
                    return true;
                }
                return false;
            }
        });
    }

    /**
     * Atempts to proceed to next activity. If it fails, there are
     * errors in the form.
     */
    private void attemptProceed() {
        mEmail.setError(null);
        mPassword.setError(null);

        boolean cancel = false;
        View focusView = null;
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();

        // Check if phone number valid
        if (TextUtils.isEmpty(email)) {
            mEmail.setError(getString(R.string.email_required));
            focusView = mPhoneNumberView;
            cancel = true;
        } else if (phoneNumber.length() < 10) {
            mPhoneNumberView.setError(getString(R.string.error_invalid_phone));
            focusView = mPhoneNumberView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Go to Different Activity
        }
    }

    public void newActivity(View view) {
        Intent intent = new Intent(this, VerifyMemberActivity.class);
        startActivity(intent);
    }
}
