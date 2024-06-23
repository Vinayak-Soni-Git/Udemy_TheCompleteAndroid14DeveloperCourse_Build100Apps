package com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.withmvvmarchitecture.di;


import com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.withmvvmarchitecture.MainDaggerActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, RepositoryModule.class})
public interface CourseShopComponent {
    void inject(MainDaggerActivity mainActivity);
}
