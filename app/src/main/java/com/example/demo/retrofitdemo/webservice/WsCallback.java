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
    
    @Multipart
    @POST(WSConstants.WS_METHOD_UPDATE_USER_PROFILE)
    Observable<ProfileResponseModel> updateUserProfileWithoutImage(@Part(WSConstants.WS_PARAM_USER_ID) RequestBody userId,
                                                                   @Part MultipartBody.Part profileImage,
                                                                   @Part(WSConstants.WS_PARAM_FNAME) RequestBody fName,
                                                                   @Part(WSConstants.WS_PARAM_LNAME) RequestBody lName,
                                                                   @Part(WSConstants.WS_PARAM_MOBILE) RequestBody mobile,
                                                                   @Part(WSConstants.WS_PARAM_ABOUT) RequestBody about,
                                                                   @Part(WSConstants.WS_PARAM_ADDRESS) RequestBody address,
                                                                   @Part(WSConstants.WS_PARAM_EMAIL) RequestBody email,
                                                                   @Part(WSConstants.WS_PARAM_SKILLS) RequestBody skills,
                                                                   @Part(WSConstants.WS_PARAM_ZIPCODE) RequestBody zipcodes);
}

 WSUtils.getClient().updateUserProfile(createPartFromString(Preference.getInstance().getUserId()), createFilePart(imageFile), createPartFromString(etFirstName.getText().toString());

   private MultipartBody.Part createFilePart(File imageFile) {
//        create RequestBody instance from file RequestBody
        RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), imageFile);
        // MultipartBody.Part is used to send also the actual file name
        return MultipartBody.Part.createFormData(WSConstants.WS_PARAM_PROFILE_PIC, imageFile.getName(), requestFile);
    }
 

 @NonNull
    private RequestBody createPartFromString(String descriptionString) {
        return RequestBody.create(
                okhttp3.MultipartBody.FORM, descriptionString);
    }
