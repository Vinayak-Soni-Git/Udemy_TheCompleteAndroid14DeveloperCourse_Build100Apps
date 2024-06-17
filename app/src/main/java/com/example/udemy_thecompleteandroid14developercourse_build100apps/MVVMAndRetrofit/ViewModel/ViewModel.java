package com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndRetrofit.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.Movie;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndRetrofit.MovieRepository;

import java.util.List;

public class ViewModel extends AndroidViewModel {
    private MovieRepository movieRepository;

    public ViewModel(@NonNull Application application){
        super(application);
        this.movieRepository = new MovieRepository(application);
    }
    public LiveData<List<Movie>> getAllMovies(){
        return movieRepository.getMutableLiveData();
    }
}
