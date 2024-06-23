package com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.contactmanagerappusingdi;

import android.app.Application;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.contactmanagerappusingdi.DI.ContactAppComponent;

public class App extends Application {

    private static App app;
    private ContactAppComponent contactAppComponent;

    public static App getApp(){
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

//        contactAppComponent = DaggerContactAppComponent.builder()
//                .applicationModule(new ApplicationModule(this))
//                .build();

        // Dagger build the components when you rebuild the project
    }
    
    public ContactAppComponent getContactAppComponent(){
        return contactAppComponent;
    }

}
