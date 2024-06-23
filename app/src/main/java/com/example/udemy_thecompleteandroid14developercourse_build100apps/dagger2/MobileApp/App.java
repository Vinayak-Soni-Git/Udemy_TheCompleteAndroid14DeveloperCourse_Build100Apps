package com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.MobileApp;

import android.app.Application;

public class App extends Application {
    private static App app;
    private MobileComponent mobileComponent;
    
    public static App getApp(){
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
