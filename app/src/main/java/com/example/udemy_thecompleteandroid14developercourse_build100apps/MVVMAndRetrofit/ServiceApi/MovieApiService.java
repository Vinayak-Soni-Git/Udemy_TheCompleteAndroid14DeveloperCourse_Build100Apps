package com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndRetrofit.ServiceApi;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndRetrofit.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {

    @GET("movie/popular")
    Call<Result> getPopularMovies(@Query("api_key") String apiKey);
}
