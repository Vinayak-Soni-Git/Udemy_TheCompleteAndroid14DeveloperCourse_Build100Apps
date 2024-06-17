package com.example.udemy_thecompleteandroid14developercourse_build100apps.FragmentsInAndroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

public class FragmentApplicationActivity extends AppCompatActivity {
    Button activeFirstFragmentButton;
    Button activeSecondFragmentButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_application);

        activeFirstFragmentButton = findViewById(R.id.activeFirstFragmentButton);
        activeSecondFragmentButton = findViewById(R.id.activeSecondFragmentButton);

        activeFirstFragmentButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                loadFragment(new FirstFragment());
            }
        });

        activeSecondFragmentButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                loadFragment(new SecondFragment());
            }
        });



    }

    public void loadFragment(Fragment fragment){
        // Responsible for all runtime management of fragments
        // including adding, removing, hiding, showing
        // and navigating between fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentFrameLayout, fragment);
        fragmentTransaction.commit();


    }
}