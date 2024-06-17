package com.example.udemy_thecompleteandroid14developercourse_build100apps.WhatsappCloneAppUsingFirebaseAndMVVM.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.ChatGroupViewModel;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

public class WhatsAppLoginActivity extends AppCompatActivity {

    ChatGroupViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whats_app_login);

        viewModel = new ViewModelProvider(this).get(ChatGroupViewModel.class);

        Button anonymousLoginButton = findViewById(R.id.anonymousLoginButton);
        anonymousLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.signUpAnonymousUser();
            }
        });

    }
}