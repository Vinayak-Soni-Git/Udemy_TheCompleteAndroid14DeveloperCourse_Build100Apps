package com.example.udemy_thecompleteandroid14developercourse_build100apps.TheJournalApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class TheJournalApp extends AppCompatActivity {
    Button loginButton, createAccountButton;
    private EditText email, password;

    //Firebase auth
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private FirebaseUser firebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_journal_app);

        createAccountButton = findViewById(R.id.signInButton);
        createAccountButton.setOnClickListener(view ->{
            Intent intent = new Intent(TheJournalApp.this, SignUpActivity.class);
            startActivity(intent);
        });

        loginButton = findViewById(R.id.logInButton);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);


        //Firebase authentication
        firebaseAuth = FirebaseAuth.getInstance();
        loginButton.setOnClickListener(view ->{
            logInEmailPasswordUser(email.getText().toString().trim(), password.getText().toString().trim());
        });

    }
    private void logInEmailPasswordUser(String email, String password){
        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
            firebaseAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    Intent intent = new Intent(TheJournalApp.this, JournalListActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
}