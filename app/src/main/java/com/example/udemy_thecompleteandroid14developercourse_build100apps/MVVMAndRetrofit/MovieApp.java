package com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndRetrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndRetrofit.Adapters.MovieAdapter;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.Movie;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndRetrofit.ViewModel.ViewModel;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.ActivityMovieAppBinding;

import java.util.ArrayList;
import java.util.List;

public class MovieApp extends AppCompatActivity {

    private ArrayList<Movie> movieArrayList;
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ActivityMovieAppBinding binding;
    private ViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_app);

        binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_movie_app
        );
        viewModel = new ViewModelProvider(this).get(ViewModel.class);

        getPopularMovies();

        swipeRefreshLayout = binding.swipeRefreshLayout;
        swipeRefreshLayout.setColorSchemeResources(R.color.black);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPopularMovies();
            }
        });

    }
    private void getPopularMovies(){
        viewModel.getAllMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> moviesFromLiveData) {
                movieArrayList = (ArrayList<Movie>)  moviesFromLiveData;
                displayMoviesInRecyclerView();
            }
        });
    }
    private void displayMoviesInRecyclerView(){
        recyclerView = binding.moviewRecyclerView;
        movieAdapter = new MovieAdapter(this, movieArrayList);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(movieAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        movieAdapter.notifyDataSetChanged();
    }
}