package com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.contactmanagerappusingdi.DI;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.contactmanagerappusingdi.DaggerContactManager;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, RoomModule.class})
public interface ContactAppComponent {

    // Let's link the modules here
    void inject(DaggerContactManager daggerContactManager);
}
