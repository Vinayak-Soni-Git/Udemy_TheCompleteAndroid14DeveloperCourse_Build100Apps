package com.example.udemy_thecompleteandroid14developercourse_build100apps.DataBindingInAndroid;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class MyClickHandler {
    Context context;

    public MyClickHandler(Context context){
        this.context = context;
    }

    public void onButton1Clicked(View view){
        Toast.makeText(context, "First Button is clicked", Toast.LENGTH_SHORT).show();
    }
}
