
package com.cc.popularmovies.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MoviesUpcoming {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("imdb_id")
    @Expose
    private String imdbId;
    @SerializedName("release")
    @Expose
    private String release;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MoviesUpcoming withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public MoviesUpcoming withImdbId(String imdbId) {
        this.imdbId = imdbId;
        return this;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public MoviesUpcoming withRelease(String release) {
        this.release = release;
        return this;
    }

}
