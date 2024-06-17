package com.example.udemy_thecompleteandroid14developercourse_build100apps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.AndroidJetpackWorkManager.MainWorkManagerActivity;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.FirebaseRealTimeDatabase.MainRealTimeDatabaseActivity;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinCoroutines.MainFirstCoroutineActivity;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.MLKitFaceDetectionApp.MainFaceDetectionActivity;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.MLKitImageToTextApp.MainImageToTextAppActivity;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.MLKitLanguageTranslatorApp.MainLanguageTranslatorActivity;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.MLKitOCRApp.MainOCRAppActivity;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.MLKitQRCodeScannerApp.MainQRCodeScannerActivity;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndRetrofit.MovieApp;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.QuadraticEquationsSolverApp.MainEquationsSolverApp;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.TheJournalApp.TheJournalApp;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.WhatsappCloneAppUsingFirebaseAndMVVM.Activities.WhatsAppLoginActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent movieAppIntent = new Intent(this, MovieApp.class);
        Button openMovieAppButton = findViewById(R.id.openMovieAppButton);
        openMovieAppButton.setOnClickListener(view ->
                startActivity(movieAppIntent));

        Intent journalAppIntent = new Intent(this, TheJournalApp.class);
        Button openJournalAppButton = findViewById(R.id.openTheJournalAppButton);
        openJournalAppButton.setOnClickListener(view ->
                startActivity(journalAppIntent));

//        Intent pagingAppIntent = new Intent(this, MainPagingApp.class);
//        Button openPagingAppButton = findViewById(R.id.openPagingAppButton);
//        openPagingAppButton.setOnClickListener(view ->
//                startActivity(pagingAppIntent));

        Intent equationSolverAppIntent = new Intent(this, MainEquationsSolverApp.class);
        Button openEquationSolverAppButton = findViewById(R.id.openEquationSolverAppButton);
        openEquationSolverAppButton.setOnClickListener(view ->
                startActivity(equationSolverAppIntent));

        Intent workManagerAppIntent = new Intent(this, MainWorkManagerActivity.class);
        Button openWorkManagerAppButton = findViewById(R.id.openWorkManagerApp);
        openWorkManagerAppButton.setOnClickListener(view ->
                startActivity(workManagerAppIntent));

        Intent realtimeDatabaseIntent = new Intent(this, MainRealTimeDatabaseActivity.class);
        Button openRealtimeDatabaseButton = findViewById(R.id.openRealtimeDatabaseApp);
        openRealtimeDatabaseButton.setOnClickListener(view ->
                startActivity(realtimeDatabaseIntent));

        Intent FirstCoroutineAppIntent = new Intent(this, MainFirstCoroutineActivity.class);
        Button openFirstCoroutineAppButton = findViewById(R.id.openFirstCoroutineAppButton);
        openFirstCoroutineAppButton.setOnClickListener(view ->
                startActivity(FirstCoroutineAppIntent));
        
        Intent WhatsAppCloneAppIntent = new Intent(this, WhatsAppLoginActivity.class);
        Button openWhatsAppCloneAppButton = findViewById(R.id.openWhatsAppCloneAppButton);
        openWhatsAppCloneAppButton.setOnClickListener(view ->
                startActivity(WhatsAppCloneAppIntent));
        
        Intent imageToTextAppIntent = new Intent(this, MainImageToTextAppActivity.class);
        Button openImageToTextAppButton = findViewById(R.id.openImageToTextAppButton);
        openImageToTextAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(imageToTextAppIntent);
            }
        });
        
        Intent translatorAppIntent = new Intent(this, MainLanguageTranslatorActivity.class);
        Button openTranslatorAppButton = findViewById(R.id.openTranslatorAppButton);
        openTranslatorAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(translatorAppIntent);
            }
        });
        
        Intent ocrAppIntent = new Intent(this, MainOCRAppActivity.class);
        Button openOCRAppButton = findViewById(R.id.openOCRAppButton);
        openOCRAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ocrAppIntent);
            }
        });
        
        Intent qrCodeScannerAppIntent = new Intent(this, MainQRCodeScannerActivity.class);
        Button openQRCODEScannerAppButton = findViewById(R.id.openQRCodeScannerAppButton);
        openQRCODEScannerAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(qrCodeScannerAppIntent);
            }
        });
        
        Intent faceDetectionAppIntent = new Intent(this, MainFaceDetectionActivity.class);
        Button openFaceDetectionAppButton = findViewById(R.id.openFaceDetectionAppButton);
        openFaceDetectionAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(faceDetectionAppIntent);
            }
        });
        
        Intent mainActivity3Intent = new Intent(this, MainActivity3.class);
        Button openMainActivity3Button = findViewById(R.id.openMainActivity3Button);
        openMainActivity3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(mainActivity3Intent);
            }
        });
        
    }
}