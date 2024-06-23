package com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.MobileApp;

import dagger.Component;

@Component(modules = NickelBatteryModule.class)
public interface MobileComponent {
    Mobile getMobile();
}
