package com.example.udemy_thecompleteandroid14developercourse_build100apps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.AdvancedRecyclerView.RecyclerViewWithMultipleItemSelection.RecyclerViewWithMultipleItemSelectionActivity;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.AdvancedRecyclerView.RecyclerViewWithMultipleViewTypes.RecyclerViewWithMultipleViewTypesActivity;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.AdvancedRecyclerView.RecyclerViewWithSingleItemSelection.RecyclerViewWithSingleItemSelectionActivity;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.QuestionsListActivity;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.FirebaseCloudMessagingApp.MainCloudMessagingAppActivity;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.IntegratingAdmob.MainAdMobAppActivity;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.IntegratingAdmob.MainInterstitialAdAppActivity;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.IntegratingAdmob.MainRewardedAdActivity;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent cloudMessagingAppIntent = new Intent(this, MainCloudMessagingAppActivity.class);
        Button openCloudMessagingAppButton = findViewById(R.id.openCloudMessagingAppButton);
        openCloudMessagingAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(cloudMessagingAppIntent);
            }
        });
        
        Intent singleItemSelectionRVAppIntent = new Intent(this, RecyclerViewWithSingleItemSelectionActivity.class);
        Button openSingleItemSelectionRVAppButton = findViewById(R.id.openRVWithSingleItemSelectionButton);
        openSingleItemSelectionRVAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(singleItemSelectionRVAppIntent);
            }
        });
        
        Intent recyclerViewWithMultipleViewTypeAppIntent = new Intent(this, RecyclerViewWithMultipleViewTypesActivity.class);
        Button openRecyclerViewWithMultipleViewAppButton = findViewById(R.id.openRVWithMultipleViewTypesAppButton);
        openRecyclerViewWithMultipleViewAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(recyclerViewWithMultipleViewTypeAppIntent);
            }
        });
        
        Intent recyclerViewWithMultipleSelectionAppIntent = new Intent(this, RecyclerViewWithMultipleItemSelectionActivity.class);
        Button openRecyclerViewWithMultipleSectionAppButton = findViewById(R.id.openRVWithMultipleSelectionAppButton);
        openRecyclerViewWithMultipleSectionAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(recyclerViewWithMultipleSelectionAppIntent);
            }
        });
        
        Intent adMobAppIntent = new Intent(this, MainAdMobAppActivity.class);
        Button openAdMobAppButton = findViewById(R.id.openAdMobAppButton);
        openAdMobAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(adMobAppIntent);
            }
        });
        
        Intent interstitialAdsAppIntent = new Intent(this, MainInterstitialAdAppActivity.class);
        Button openInterstitialAdsAppButton = findViewById(R.id.openInterstitialAdAppButton);
        openInterstitialAdsAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(interstitialAdsAppIntent);
            }
        });
        
        Intent rewardedAdsAppIntent = new Intent(this, MainRewardedAdActivity.class);
        Button openRewardedAdsAppButton = findViewById(R.id.openRewardedAdAppButton);
        openRewardedAdsAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(rewardedAdsAppIntent);
            }
        });
        
        Intent dependencyInjectionAppIntent = new Intent(this, QuestionsListActivity.class);
        Button openDependencyInjectionAppButton = findViewById(R.id.openDependencyInjectionAppButton);
        openDependencyInjectionAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(dependencyInjectionAppIntent);
            }
        });
    }
}