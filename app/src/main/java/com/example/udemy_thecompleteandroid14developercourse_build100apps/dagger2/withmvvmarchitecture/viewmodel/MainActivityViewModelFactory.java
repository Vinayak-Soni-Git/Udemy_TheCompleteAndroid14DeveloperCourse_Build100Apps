package com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.withmvvmarchitecture.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.withmvvmarchitecture.model.CourseShopRepository;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class MainActivityViewModelFactory implements ViewModelProvider.Factory {

   private final CourseShopRepository courseShopRepository;

   @Inject
    public MainActivityViewModelFactory(CourseShopRepository courseShopRepository) {
        this.courseShopRepository = courseShopRepository;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T)new MainActivityViewModel(courseShopRepository);
    }
}
