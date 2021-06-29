package com.cc.popularmovies.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.cc.popularmovies.databinding.MovieListItemBinding;
import com.cc.popularmovies.model.MoviesUpcoming;
import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        MovieListItemBinding binding = MovieListItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );

        return new MovieViewHolder(binding);
    }

    private List<MoviesUpcoming> results = new ArrayList<>();

    public void setResults(List<MoviesUpcoming> results){
        this.results = results;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {

        MoviesUpcoming result = results.get(position);

        holder.binding.titleTextview.setText(result.getTitle());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder{
        MovieListItemBinding binding;

        public MovieViewHolder(MovieListItemBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
