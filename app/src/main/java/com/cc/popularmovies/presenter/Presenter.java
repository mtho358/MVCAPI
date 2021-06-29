package com.cc.popularmovies.presenter;

import com.cc.popularmovies.model.MovieResponse;

import java.util.List;

public interface Presenter {

    interface MoviePresenter{
        void getMovieResults();
    }

    interface MovieView{
        void displayResults(List<MovieResponse> movieResponseList);
        void displayError(String error);
    }
}
