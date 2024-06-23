package com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.MobileApp;

import android.util.Log;

import javax.inject.Inject;

public class NickelBattery implements BatteryTypes{

    @Inject
    public NickelBattery(){
        
    }
    
    @Override
    public void showType() {
        Log.v("TagY", "This is a nickel Battery");
    }
}
