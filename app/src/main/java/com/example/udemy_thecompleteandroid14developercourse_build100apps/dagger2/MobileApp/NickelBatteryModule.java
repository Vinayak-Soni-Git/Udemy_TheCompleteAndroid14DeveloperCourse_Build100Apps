package com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.MobileApp;

import androidx.annotation.NonNull;

import dagger.Module;
import dagger.Provides;

@Module
public class NickelBatteryModule {
    @Provides
    BatteryTypes provideNickelBattery(@NonNull NickelBattery nickelBattery){
        nickelBattery.showType();
        return nickelBattery;
    }
}
