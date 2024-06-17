package com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndPagingLibrary.ViewModel;

import androidx.lifecycle.ViewModelKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.rxjava3.PagingRx;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndPagingLibrary.Model.Movie;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndPagingLibrary.Paging.MoviePagingSource;

import io.reactivex.rxjava3.core.Flowable;
import kotlinx.coroutines.CoroutineScope;

public class MoviesPagingViewModel extends androidx.lifecycle.ViewModel {
    public Flowable<PagingData<Movie>> moviePagingDataFlowable;
    
    public MoviesPagingViewModel(){
        init();
    }
    
    private void init(){
        MoviePagingSource moviePagingSource = new MoviePagingSource();

        Pager<Integer, Movie> pager = new Pager(new PagingConfig(
                20, 
                20, 
                false, 
                20,
                20*499),
                () -> moviePagingSource);
        
        //Flowable
        moviePagingDataFlowable = PagingRx.getFlowable(pager);
        CoroutineScope coroutineScope = ViewModelKt.getViewModelScope(this);
        PagingRx.cachedIn(moviePagingDataFlowable, coroutineScope);
    }
}
