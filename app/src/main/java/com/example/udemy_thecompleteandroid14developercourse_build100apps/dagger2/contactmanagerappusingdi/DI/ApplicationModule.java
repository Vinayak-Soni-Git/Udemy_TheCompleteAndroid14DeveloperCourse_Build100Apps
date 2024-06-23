package com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.contactmanagerappusingdi.DI;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    // This will act as application dependency  "getApplicationContext()"

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }


    // to provide application instance, we need provide method
    @Provides
    @Singleton
    Application providesApplication(){
        return application;
    }
}
