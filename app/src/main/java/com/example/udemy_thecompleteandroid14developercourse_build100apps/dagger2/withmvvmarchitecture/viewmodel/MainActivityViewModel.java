package com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.withmvvmarchitecture.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.withmvvmarchitecture.model.Category;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.withmvvmarchitecture.model.Course;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.withmvvmarchitecture.model.CourseShopRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    // Repository
    private CourseShopRepository repository;

    // Live Data
    private LiveData<List<Category>> allCategories;
    private LiveData<List<Course>> coursesOfSelectedCategory;


    public MainActivityViewModel(CourseShopRepository courseShopRepository) {
        this.repository = courseShopRepository;
    }

    public LiveData<List<Category>> getAllCategories(){
        allCategories = repository.getCategories();
        return allCategories;
    }

    public LiveData<List<Course>> getCoursesOfSelectedCategory(int categoryId){
        coursesOfSelectedCategory = repository.getCourses(categoryId);
        return coursesOfSelectedCategory;
    }

    public void addNewCourse(Course course){
        repository.insertCourse(course);
    }

    public void updateCourse(Course course){
        repository.updateCourse(course);
    }

    public void deleteCourse(Course course){
        repository.deleteCourse(course);
    }



}
