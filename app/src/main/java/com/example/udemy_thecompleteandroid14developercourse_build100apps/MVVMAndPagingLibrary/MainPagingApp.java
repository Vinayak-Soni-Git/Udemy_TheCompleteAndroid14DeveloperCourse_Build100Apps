package com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndPagingLibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.bumptech.glide.RequestManager;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndPagingLibrary.Adapter.MoviesLoadStateAdapter;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndPagingLibrary.Adapter.MoviesPagingAdapter;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndPagingLibrary.Util.GridSpace;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndPagingLibrary.Util.MovieComparator;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndPagingLibrary.Util.Utils;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndPagingLibrary.ViewModel.MoviesPagingViewModel;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.ActivityMainPagingAppBinding;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainPagingApp extends AppCompatActivity {
    
    
    MoviesPagingViewModel mainActivityMoviesPagingViewModel;
    ActivityMainPagingAppBinding binding;
    MoviesPagingAdapter moviesPagingAdapter;
    
    @Inject
    RequestManager requestManager;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainPagingAppBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        
        if (Utils.API_KEY == null || Utils.API_KEY.isEmpty()){
            Toast.makeText(this, "Error in API Key", Toast.LENGTH_SHORT).show();
        }
        
        moviesPagingAdapter = new MoviesPagingAdapter(new MovieComparator(), requestManager);
        mainActivityMoviesPagingViewModel = new ViewModelProvider(this).get(MoviesPagingViewModel.class);
        
        initRecyclerViewAndAdapter();
        
        mainActivityMoviesPagingViewModel.moviePagingDataFlowable.subscribe(moviePagingData -> {
            moviesPagingAdapter.submitData(getLifecycle(), moviePagingData);
        });
        
        
    }

    private void initRecyclerViewAndAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        binding.pagingAppRecyclerView.setLayoutManager(gridLayoutManager);
        binding.pagingAppRecyclerView.addItemDecoration(new GridSpace(2, 20, true));
        binding.pagingAppRecyclerView.setAdapter(
                moviesPagingAdapter.withLoadStateFooter(
                        new MoviesLoadStateAdapter(view ->
                                moviesPagingAdapter.retry())
                )
        );
        
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(){
            @Override
            public int getSpanSize(int position) {
                return moviesPagingAdapter.getItemViewType(position) == MoviesPagingAdapter.LOADING_ITEM?1:2;
            }
        });
    }
}