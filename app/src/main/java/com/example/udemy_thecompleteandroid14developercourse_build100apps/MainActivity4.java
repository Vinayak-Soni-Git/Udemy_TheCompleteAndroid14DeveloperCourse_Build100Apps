package com.example.udemy_thecompleteandroid14developercourse_build100apps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.AnimationAndMaterialDesign.FashionApp.FashionApp;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.ArchitecturePatterns.MVCPattern.MVCPatternActivity;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.ArchitecturePatterns.MVPPattern.MVPPatternActivity;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.ArchitecturePatterns.MVVMPattern.MVVMPatternActivity;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNavigationApp.KotlinNavigationApp;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNavigationDrawerApp.KotlinNavigationDrawer;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinPlanetApp.KotlinPlanetApp;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinSportsApp.KotlinSportsApp;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinVolumeCalculatorApp.KotlinVolumeCalculatorApp;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.kotlincontactmanagerapp.KotlinContactManagerApp;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Intent fashionAppIntent = new Intent(this, FashionApp.class);
        Button openFashionAppButton = findViewById(R.id.openFashionAppButton);
        openFashionAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(fashionAppIntent);
            }
        });

        Intent kotlinPlanetAppIntent = new Intent(this, KotlinPlanetApp.class);
        Button openKotlinPlanetAppButton = findViewById(R.id.openPlanetAppButton);
        openKotlinPlanetAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(kotlinPlanetAppIntent);
            }
        });
        
        Intent kotlinVolumeCalculatorAppIntent = new Intent(this, KotlinVolumeCalculatorApp.class);
        Button openVolumeCalculatorAppButton = findViewById(R.id.openVolumeCalculatorAppButton);
        openVolumeCalculatorAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(kotlinVolumeCalculatorAppIntent);
            }
        });
        
        Intent kotlinContactManagerAppIntent = new Intent(this, KotlinContactManagerApp.class);
        Button openKotlinContactManagerAppButton = findViewById(R.id.openKotlinContactManagerAppButton);
        openKotlinContactManagerAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(kotlinContactManagerAppIntent);
            }
        });
        
        Intent kotlinNavigationAppIntent = new Intent(this, KotlinNavigationApp.class);
        Button openKotlinNavigationAppButton = findViewById(R.id.openKotlinNavigationAppButton);
        openKotlinNavigationAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(kotlinNavigationAppIntent);
            }
        });
        
        Intent kotlinSportsAppIntent = new Intent(this, KotlinSportsApp.class);
        Button openKotlinSportsAppButton = findViewById(R.id.openKotlinSportsAppButton);
        openKotlinSportsAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(kotlinSportsAppIntent);
            }
        });
        
        Intent kotlinNavigationDrawerAppIntent = new Intent(this, KotlinNavigationDrawer.class);
        Button openKotlinNavigationDrawerAppButton = findViewById(R.id.openKotlinNavigationDrawerAppButton);
        openKotlinNavigationDrawerAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(kotlinNavigationDrawerAppIntent);
            }
        });
        
        Intent mvcPatternAppIntent = new Intent(this, MVCPatternActivity.class);
        Button openMVCPatternAppButton = findViewById(R.id.openMVCPatternAppButton);
        openMVCPatternAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(mvcPatternAppIntent);
            }
        });
        
        Intent mvpPatternAppIntent = new Intent(this, MVPPatternActivity.class);
        Button openMVPPatternAppButton = findViewById(R.id.openMVPPatternAppButton);
        openMVPPatternAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(mvpPatternAppIntent);
            }
        });
        
        Intent mvvmPatternAppIntent = new Intent(this, MVVMPatternActivity.class);
        Button openMVVMPatternAppButton = findViewById(R.id.openMVVMPatternAppButton);
        openMVVMPatternAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(mvvmPatternAppIntent);
            }
        });
    }
}