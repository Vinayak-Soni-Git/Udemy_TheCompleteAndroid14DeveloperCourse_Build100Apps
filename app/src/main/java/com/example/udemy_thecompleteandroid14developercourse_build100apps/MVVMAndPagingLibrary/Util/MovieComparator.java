package com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndPagingLibrary.Util;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndPagingLibrary.Model.Movie;

public class MovieComparator extends DiffUtil.ItemCallback<Movie> {

    @Override
    public boolean areItemsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
        return oldItem.getId() == newItem.getId();
    }
}
