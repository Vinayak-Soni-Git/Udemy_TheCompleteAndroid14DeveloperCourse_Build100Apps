package com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.withmvvmarchitecture.di;

import android.app.Application;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.withmvvmarchitecture.model.CourseShopRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    CourseShopRepository providesCourseShopRepository(Application application){
        return new CourseShopRepository(application);
    }
}
