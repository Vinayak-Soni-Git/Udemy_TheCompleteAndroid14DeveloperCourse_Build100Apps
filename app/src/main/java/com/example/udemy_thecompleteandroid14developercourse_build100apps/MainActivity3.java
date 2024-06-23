package com.example.udemy_thecompleteandroid14developercourse_build100apps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.AdvancedRecyclerView.RecyclerViewWithMultipleItemSelection.RVWithMISelection;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.AdvancedRecyclerView.RecyclerViewWithMultipleViewTypes.RVWithMultipleViewTypes;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.AdvancedRecyclerView.RecyclerViewWithSingleItemSelection.RVWithSingleItemSelection;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.AnimationAndMaterialDesign.FoodApp.FoodAppUI;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.AnimationAndMaterialDesign.FurnitureApp.FurnitureApp;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.QuestionsListActivity;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.FirebaseCloudMessagingApp.MainCloudMessagingAppActivity;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.IntegratingAdmob.MainAdMobAppActivity;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.IntegratingAdmob.MainInterstitialAdAppActivity;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.IntegratingAdmob.MainRewardedAdActivity;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinGroceryApp.KotlinGroceryApp;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinLotteryApp.KotlinLotteryApp;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.MainNoteTakingAppActivity;

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
        
        Intent singleItemSelectionRVAppIntent = new Intent(this, RVWithSingleItemSelection.class);
        Button openSingleItemSelectionRVAppButton = findViewById(R.id.openRVWithSingleItemSelectionButton);
        openSingleItemSelectionRVAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(singleItemSelectionRVAppIntent);
            }
        });
        
        Intent recyclerViewWithMultipleViewTypeAppIntent = new Intent(this, RVWithMultipleViewTypes.class);
        Button openRecyclerViewWithMultipleViewAppButton = findViewById(R.id.openRVWithMultipleViewTypesAppButton);
        openRecyclerViewWithMultipleViewAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(recyclerViewWithMultipleViewTypeAppIntent);
            }
        });
        
        Intent recyclerViewWithMultipleSelectionAppIntent = new Intent(this, RVWithMISelection.class);
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
        
        Intent noteTakingAppIntent = new Intent(this, MainNoteTakingAppActivity.class);
        Button openNoteTakingAppButton = findViewById(R.id.openNoteTakingAppButton);
        openNoteTakingAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(noteTakingAppIntent);
            }
        });
        
        Intent lotteryAppIntent = new Intent(this, KotlinLotteryApp.class);
        Button openLotteryAppButton = findViewById(R.id.openLotteryAppButton);
        openLotteryAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(lotteryAppIntent);
            }
        });
        
        Intent kotlinGroceryAppIntent = new Intent(this, KotlinGroceryApp.class);
        Button openKotlinGroceryAppButton = findViewById(R.id.openGroceryAppButton);
        openKotlinGroceryAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(kotlinGroceryAppIntent);
            }
        });
        
        Intent foodAppUIIntent = new Intent(this, FoodAppUI.class);
        Button openFoodAppUIBUtton = findViewById(R.id.openFoodAppUIButton);
        openFoodAppUIBUtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(foodAppUIIntent);
            }
        });
        
        Intent furnitureAppIntent = new Intent(this, FurnitureApp.class);
        Button openFurnitureAppButton = findViewById(R.id.openFurnitureAppButton);
        openFurnitureAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(furnitureAppIntent);
            }
        });

        Intent mainActivity4Intent = new Intent(this, MainActivity4.class);
        Button openMainActivity4Button = findViewById(R.id.openMainActivity4Button);
        openMainActivity4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(mainActivity4Intent);
            }
        });
        
    }
}