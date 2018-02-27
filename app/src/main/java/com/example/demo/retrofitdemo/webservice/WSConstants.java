package com.example.demo.retrofitdemo.webservice;

/**
 * Common webservice constants.
 */

public class WSConstants {

    /**
     * Webservice url
     */
    static final String WS_BASE_URL = "http://api.themoviedb.org/3/";

    /**
     * Webservice api key
     */
    static final String WS_API_KEY = "api_key";
    /**
     * Webservice methods
     */
    static final String WS_METHOD_TOP_RATED_MOVIES = "movie/top_rated";
    static final String WS_METHOD_MOVIE_DETAILS = "movie/{id}";

    /**
     * Webservice parameters
     */
    static final String WS_PARAM_ID = "id";

    public static final String WS_STATUS_SUCCESS = "1";
    public static final String WS_STATUS_FAIL = "0";

    public static final String WS_RESPONSE_DATA = "data";
    public static final String WS_RESPONSE_SETTINGS = "settings";

    static final int WS_CONNECTION_TIMEOUT = 60;
    static final int WS_READ_TIMEOUT = 60;
}