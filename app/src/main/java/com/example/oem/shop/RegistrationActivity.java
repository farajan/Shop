package com.example.oem.shop;

import android.app.ProgressDialog;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {

    private Button mSigUp;
    private EditText mEmail, mPassword1, mPassword2;
    private CheckBox mLicence;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    private ProgressDialog mProgress;

    private void initActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_logo);
    }

    private void init() {
        mSigUp = (Button) findViewById(R.id.sigUp);
        mEmail = (EditText) findViewById(R.id.email);
        mPassword1 = (EditText) findViewById(R.id.password1);
        mPassword2 = (EditText) findViewById(R.id.password2);
        mLicence = (CheckBox) findViewById(R.id.licence);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mProgress = new ProgressDialog(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initActionBar();
        init();

        mSigUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startRegister();

            }
        });
    }

    private void startRegister() {

        final String email = mEmail.getText().toString();
        String password1 = mPassword1.getText().toString();
        String password2 = mPassword2.getText().toString();

        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password1) && !TextUtils.isEmpty(password2) && password1.equals(password2)) {

            mProgress.setMessage("Signing up ...");
            mProgress.show();

            mAuth.createUserWithEmailAndPassword(email, password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {

                        writeNewUser(mAuth.getCurrentUser().getUid(), email, "default");
                        mProgress.dismiss();
                        startActivity(new Intent(RegistrationActivity.this, HomeActivity.class));

                    }

                }
            });

        }
    }

    private void writeNewUser(String userId, String email, String photoURL) {
        User user = new User(email, "default");
        mDatabase.child("test").child(userId).setValue(user);
    }
}
