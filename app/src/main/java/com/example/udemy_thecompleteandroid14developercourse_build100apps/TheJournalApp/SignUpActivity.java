package com.example.udemy_thecompleteandroid14developercourse_build100apps.TheJournalApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignUpActivity extends AppCompatActivity {
    EditText userName, userEmail, userPassword;
    Button signUpButton;

    //Firebase Auth
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private FirebaseUser firebaseUser;

    //Firebase connection
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference collectionReference = db.collection("Users");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        userEmail = findViewById(R.id.signUpEmail);
        userPassword = findViewById(R.id.signUpPassword);
        userName = findViewById(R.id.signUpUserName);
        signUpButton = findViewById(R.id.signUpButton);

        //Firebase auth
        firebaseAuth = FirebaseAuth.getInstance();

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                firebaseUser = firebaseAuth.getCurrentUser();

                if (firebaseUser != null){
                    //user already logged in
                }
                else{
                    //the user signed out
                }
            }
        };

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(userEmail.getText().toString())
                        &&!TextUtils.isEmpty(userName.getText().toString())
                        &&!TextUtils.isEmpty(userPassword.getText().toString())){

                        String name = userName.getText().toString().trim();
                        String email = userEmail.getText().toString().trim();
                        String password = userPassword.getText().toString().trim();

                        createUserEmailAccount(email, password, name);

                }
                else {
                    Toast.makeText(SignUpActivity.this, "No Empty fields are allowed!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    private void createUserEmailAccount(String email, String password, String userName){
        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(userName)){
            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        // The user is created successfully!
                        Toast.makeText(SignUpActivity.this, "Account is created successfully", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}