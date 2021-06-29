package com.cc.popularmovies.presenter;

import android.util.Log;

import com.cc.popularmovies.model.MovieResponse;
import com.cc.popularmovies.model.network.MovieRetrofit;
import com.cc.popularmovies.view.MovieAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviePresenter implements Presenter.MoviePresenter{

    private Presenter.MovieView movieView;
    private final MovieAdapter adapter = new MovieAdapter();

    public MoviePresenter(Presenter.MovieView movieView) {
        this.movieView = movieView;
    }

    private final MovieRetrofit movieRetrofit = new MovieRetrofit();

    @Override
    public void getMovieResults() {

        new Thread(){

            @Override
            public void run() {
                super.run();
                try{
                    movieRetrofit.getAllUpcomingMovies()
                            .enqueue(new Callback<MovieResponse>() {
                                @Override
                                public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
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
                    movieView.displayError(e.getMessage());
                }
            }
        }.start();
    }
}
