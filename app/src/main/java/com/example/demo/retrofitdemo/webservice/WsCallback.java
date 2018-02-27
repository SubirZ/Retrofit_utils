package com.example.demo.retrofitdemo.webservice;

import com.example.demo.retrofitdemo.model.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * interface providing all necessary methods for all network callback methods.
 */
public interface WsCallback {

    @GET(WSConstants.WS_METHOD_TOP_RATED_MOVIES)
    Call<MoviesResponse> getTopRatedMovies(@Query(WSConstants.WS_API_KEY) String apiKey);

    @GET(WSConstants.WS_METHOD_MOVIE_DETAILS)
    Call<MoviesResponse> getMovieDetails(@Path(WSConstants.WS_PARAM_ID) int id, @Query(WSConstants.WS_API_KEY) String apiKey);
}