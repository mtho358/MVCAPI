package com.cc.popularmovies.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.cc.popularmovies.databinding.ActivityMainBinding;
import com.cc.popularmovies.model.MovieResponse;
import com.cc.popularmovies.model.MoviesUpcoming;
import com.cc.popularmovies.model.network.MovieRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final MovieAdapter adapter = new MovieAdapter();

    private final MovieRetrofit movieRetrofit = new MovieRetrofit();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.cc.popularmovies.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.movieRecyclerview.setAdapter(adapter);

        new Thread() {

            @Override
            public void run() {
                super.run();
                try{
                    movieRetrofit.getAllUpcomingMovies().enqueue(new Callback<MovieResponse>() {
                            @Override
                            public void onResponse
                                    (Call<MovieResponse> call, Response<MovieResponse> response) {
                                assert response.body() != null;
                                adapter.setResults(response.body().getMoviesUpcoming());
                            }

                            @Override
                            public void onFailure(Call<MovieResponse> call, Throwable t) {
                                Log.d("TAG_M", "OOPS..." + call.request().url());
                            }
                        });
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();
    }
}