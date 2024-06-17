package com.example.udemy_thecompleteandroid14developercourse_build100apps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.AdaptersInAndroid.AdapterActivity;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.AdaptersInAndroid.CustomAdapterActivity;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.CardViewTheSportsApp.SportsApp;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.FragmentsInAndroid.FragmentApplicationActivity;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.FragmentsInAndroid.ViewPagerApp;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.FrenchTeacherApp.MainFrenchTeacherAppActivity;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.LiveDataViewModelDataBinding.ViewModelApp;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.LuckyNumberApp.MainLuckyNumberAppActivity;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndRoomDB.ContactsManagerApp;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.MasteringAdapterAndGridView.VolumeAreaApp;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.MoreWidgets.MoreWidgets;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.RecyclerViewTheGroceryApp.GroceryApp;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent luckyNumberAppIntent = new Intent(this, MainLuckyNumberAppActivity.class);
        Button openLuckyNumberAppButton = findViewById(R.id.openLuckyNumberAppButton);
        openLuckyNumberAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(luckyNumberAppIntent);
            }
        });
        
        Intent moreWidgetsIntent = new Intent(this, MoreWidgets.class);
        Button openMoreWidgetsButton = findViewById(R.id.openMoreWidgetsButton);
        openMoreWidgetsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(moreWidgetsIntent);
            }
        });

        Intent frenchTeacherAppIntent = new Intent(this, MainFrenchTeacherAppActivity.class);
        Button openFrenchTeacherAppButton = findViewById(R.id.openFrenchTeacherAppButton);
        openFrenchTeacherAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(frenchTeacherAppIntent);
            }
        });

        Intent adapterActivityIntent = new Intent(this, AdapterActivity.class);
        Button openAdapterActivityIntent = findViewById(R.id.openAdapterActivityButton);
        openAdapterActivityIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(adapterActivityIntent);
            }
        });

        Intent customAdapterIntent = new Intent(this, CustomAdapterActivity.class);
        Button openCustomAdapterButton = findViewById(R.id.openCustomAdapterButton);
        openCustomAdapterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(customAdapterIntent);
            }
        });

        Intent volumeAreaAppIntent = new Intent(this, VolumeAreaApp.class);
        Button openVolumeAreaAppButton = findViewById(R.id.openVolumeAreaAppButton);
        openVolumeAreaAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(volumeAreaAppIntent);
            }
        });
        
        Intent groceryAppIntent = new Intent(this, GroceryApp.class);
        Button openGroceryAppButton = findViewById(R.id.openGroceryAppButton);
        openGroceryAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(groceryAppIntent);
            }
        });

        Intent sportsAppIntent = new Intent(this, SportsApp.class);
        Button openSportsAppButton = findViewById(R.id.openSportsAppButton);
        openSportsAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(sportsAppIntent);
            }
        });

        Intent fragmentApplicationIntent = new Intent(this, FragmentApplicationActivity.class);
        Button openFragmentApplicationButton = findViewById(R.id.openFragmentApplicationButton);
        openFragmentApplicationButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(fragmentApplicationIntent);
            }
        });

        Intent viewPagerAppIntent = new Intent(this, ViewPagerApp.class);
        Button openViewPagerAppButton = findViewById(R.id.openViewPagerAppButton);
        openViewPagerAppButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(viewPagerAppIntent);
            }
        });

        Intent viewModelAppButton = new Intent(this, ViewModelApp.class);
        Button openViewModelAppButton = findViewById(R.id.openViewModelAppButton);
        openViewModelAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(viewModelAppButton);
            }
        });

        Intent contactManagerAppButton = new Intent(this, ContactsManagerApp.class);
        Button openContactManagerAppButton = findViewById(R.id.openContactManagerAppButton);
        openContactManagerAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(contactManagerAppButton);
            }
        });

        Intent mainActivity2Intent = new Intent(this, MainActivity2.class);
        Button openMainActivity2Button = findViewById(R.id.openMainActivity2Button);
        openMainActivity2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(mainActivity2Intent);
            }
        });

    }
}