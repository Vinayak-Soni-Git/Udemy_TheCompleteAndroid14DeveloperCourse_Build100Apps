package com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.withmvvmarchitecture.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    Application providesApplication(){
        return application;
    }
}
