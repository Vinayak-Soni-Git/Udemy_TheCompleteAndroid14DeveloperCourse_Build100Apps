package com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndPagingLibrary.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndPagingLibrary.Model.Movie;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.PagingAppSingleMovieItemBinding;

public class MoviesPagingAdapter extends PagingDataAdapter<Movie, MoviesPagingAdapter.MoviesPagingViewHolder> {
    public static final int LOADING_ITEM = 0;
    public static final int MOVIE_ITEM = 1;
    
    RequestManager glide;

    public MoviesPagingAdapter(@NonNull DiffUtil.ItemCallback<Movie> diffCallback, RequestManager glide) {
        super(diffCallback);
        this.glide = glide;
    }

    @NonNull
    @Override
    public MoviesPagingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MoviesPagingViewHolder(PagingAppSingleMovieItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public int getItemViewType(int position) {
        return position == getItemCount() ? MOVIE_ITEM: LOADING_ITEM;
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesPagingViewHolder holder, int position) {
        Movie currentMovie = getItem(position);
        
        if (currentMovie != null){
            glide.load("https://image.tmdb.org/t/p/w500"+ currentMovie.getPosterPath())
                    .into(holder.pagingAppSingleMovieItemBinding.pagingAppImageView);
            
            holder.pagingAppSingleMovieItemBinding.pagingAppRating.setText(String.valueOf(currentMovie.getVoteAverage()));
        }
        
        
    }

    public class MoviesPagingViewHolder extends RecyclerView.ViewHolder{
        PagingAppSingleMovieItemBinding pagingAppSingleMovieItemBinding;
        public MoviesPagingViewHolder(@NonNull PagingAppSingleMovieItemBinding pagingAppSingleMovieItemBinding){
            super(pagingAppSingleMovieItemBinding.getRoot());
            
            this.pagingAppSingleMovieItemBinding = pagingAppSingleMovieItemBinding;
        }
    }
}
