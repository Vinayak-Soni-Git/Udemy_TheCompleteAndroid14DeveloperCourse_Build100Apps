package com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.withmvvmarchitecture;

import android.app.Application;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.withmvvmarchitecture.di.CourseShopComponent;

public class App extends Application {
    private static App app;
    private CourseShopComponent courseShopComponent;

    public static App getApp() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

//        courseShopComponent = DaggerCourseShopComponent.
//             builder().appModule(new AppModule(this)).build();
    }


}
