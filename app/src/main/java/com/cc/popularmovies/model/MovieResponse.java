
package com.cc.popularmovies.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MovieResponse {

    @SerializedName("Movies Upcoming")
    @Expose
    private List<MoviesUpcoming> moviesUpcoming = null;

    public List<MoviesUpcoming> getMoviesUpcoming() {
        return moviesUpcoming;
    }

    public void setMoviesUpcoming(List<MoviesUpcoming> moviesUpcoming) {
        this.moviesUpcoming = moviesUpcoming;
    }

    public MovieResponse withMoviesUpcoming(List<MoviesUpcoming> moviesUpcoming) {
        this.moviesUpcoming = moviesUpcoming;
        return this;
    }

}
