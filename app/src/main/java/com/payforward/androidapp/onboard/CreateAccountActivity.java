package com.payforward.androidapp.onboard;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.payforward.androidapp.R;

public class CreateAccountActivity extends AppCompatActivity {
    private EditText mEmail;
    private EditText mPassword;
    private FirebaseAuth mAuth;
    private final String TAG = "CreateAccountActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        // Set progress bar
        ProgressDialog progress = new ProgressDialog(this);
        progress.setProgress(10);

        // Set EditTexts
        mEmail = (EditText) findViewById(R.id.email);
        mPassword = (EditText) findViewById(R.id.password);

        mAuth = FirebaseAuth.getInstance();

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

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        // TODO: Implement this
        // FirebaseUser currentUser = mAuth.getCurrentUser();
        // updateUI(currentUser);
    }

    /**
     * Attempts to proceed to next activity. If it fails, there are
     * errors in the form.
     */
    private void attemptProceed() {
        mEmail.setError(null);
        mPassword.setError(null);

        boolean cancel = false;
        View focusView = null;
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();

        // Check if email valid
        if (TextUtils.isEmpty(email)) {
            mEmail.setError(getString(R.string.required_error));
            focusView = mEmail;
            cancel = true;
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmail.setError(getString(R.string.invalid_email_error));
            focusView = mEmail;
            cancel = true;
        }

        // Check if password valid
        else if (TextUtils.isEmpty(password)) {
            mPassword.setError(getString(R.string.required_error));
            focusView = mPassword;
            cancel = true;
        } else if (password.length() < 6) {
            mPassword.setError(getString(R.string.password_length_error));
            focusView = mPassword;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "createUserWithEmail:success");
                                // TODO: Implement this
                                // FirebaseUser user = mAuth.getCurrentUser();
                                // updateUI(user);
                                startActivity(new Intent(CreateAccountActivity.this, VerifyMemberActivity.class));
                            } else {
                                // TODO: Need logic for already signed-up user
                                // If sign in fails, display a message to the user.
                                Log.d(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(CreateAccountActivity.this, task.getException().getMessage(),
                                        Toast.LENGTH_SHORT).show();
                                // updateUI(null);
                            }
                        }
                    });
        }
    }

    public void fabClicked(View view) {
        attemptProceed();
    }
}
