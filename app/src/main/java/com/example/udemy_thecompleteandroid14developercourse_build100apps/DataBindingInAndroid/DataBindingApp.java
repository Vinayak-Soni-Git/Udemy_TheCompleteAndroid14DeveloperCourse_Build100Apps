package com.example.udemy_thecompleteandroid14developercourse_build100apps.DataBindingInAndroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.ActivityDataBindingAppBinding;

public class DataBindingApp extends AppCompatActivity {
    private ActivityDataBindingAppBinding activityDataBindingAppBinding;
    private MyClickHandler myClickHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_binding_app);

        Person p1 = new Person("Jack", "jack@gmail.com");

//        activityDataBindingAppBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_app);
//        activityDataBindingAppBinding.setPerson(p1);
//
//        myClickHandler = new MyClickHandler(this);
//        activityDataBindingAppBinding.setClickHandler(myClickHandler);
    }
}