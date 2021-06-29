package com.cc.popularmovies.model.network;

import com.cc.popularmovies.model.MovieResponse;
import com.cc.popularmovies.model.MoviesUpcoming;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import static com.cc.popularmovies.util.Constants.BASE_URL;
import static com.cc.popularmovies.util.Constants.END_POINT;

public class MovieRetrofit {

    private MovieService movieService = createRetrofit().create(MovieService.class);

    private Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

    public Call<MovieResponse> getAllUpcomingMovies(){
        return movieService.getAllUpcomingMovies();
    }

    interface MovieService{
        @Headers("x-rapidapi-key: 9eb116990dmsh910b19c03622d6dp1f3723jsn2376ebf671af")
        @GET(END_POINT)
        public Call<MovieResponse> getAllUpcomingMovies();

    }
}
