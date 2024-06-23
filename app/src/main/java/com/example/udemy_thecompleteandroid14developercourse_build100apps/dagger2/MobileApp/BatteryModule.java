package com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.MobileApp;

import dagger.Module;
import dagger.Provides;

@Module
public class BatteryModule {

    @Provides
    Battery provideBattery(){
        return new Battery();
    }
}
