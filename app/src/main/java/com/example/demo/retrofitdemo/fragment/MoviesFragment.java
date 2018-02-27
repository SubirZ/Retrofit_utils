package com.example.demo.retrofitdemo.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.demo.retrofitdemo.App;
import com.example.demo.retrofitdemo.R;
import com.example.demo.retrofitdemo.adapter.ItemsAdapter;
import com.example.demo.retrofitdemo.databinding.FragmentMoviesBinding;
import com.example.demo.retrofitdemo.model.MovieModel;
import com.example.demo.retrofitdemo.model.MoviesResponse;
import com.example.demo.retrofitdemo.util.Constants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by SC on 27/02/18.
 */

public class MoviesFragment extends BaseFragmentBinding<FragmentMoviesBinding> implements ItemsAdapter.OnItemClickListener {
    private ItemsAdapter itemsAdapter;
    private List<MovieModel> movies = new ArrayList<>();

    @Override
    protected int defineLayoutResource() {
        return R.layout.fragment_movies;
    }

    @Override
    protected void initializeComponent(View view) {
        binding.activityMoviesRvMovies.setLayoutManager(new LinearLayoutManager(getActivity()));
        itemsAdapter = new ItemsAdapter(getActivity(), movies, this);
        binding.activityMoviesRvMovies.setAdapter(itemsAdapter);

        setData();
    }

    private void setData() {
        Call<MoviesResponse> moviesCall = App.getRetrofitInstance().getTopRatedMovies(Constants.API_KEY);
        moviesCall.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                if (response != null) {
                    movies.addAll(response.body().getResults());
                    itemsAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void onItemClick(int position) {

    }
}