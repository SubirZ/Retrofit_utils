package com.example.retrofit.webservice;

import com.example.retrofit.model.LoginModel;
import com.example.retrofit.model.LoginResponseModel;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * interface providing all necessary methods for all network callback methods.
 */
public interface WsCallback {

    @Headers({WSConstants.WS_HEADER_ORIGIN})
    @POST(WSConstants.WS_METHOD_USERS_REGISTRATION)
    Call<BaseModel> registerUser(@Body LoginModel loginModel);

    @Headers({WSConstants.WS_HEADER_ORIGIN})
    @POST(WSConstants.WS_METHOD_USERS_LOGIN)
    Call<LoginResponseModel> login(@Body LoginModel loginModel);

    @Headers({WSConstants.WS_HEADER_ORIGIN})
    @POST(WSConstants.WS_METHOD_FORGOT_PASSWORD)
    Call<BaseModel> forgotPassword(@Body LoginModel loginModel);

    @GET(WSConstants.WS_METHOD_USERS_LOGOUT)
    Call<BaseModel> logout();

    @Multipart
    @POST(WSConstants.WS_METHOD_UPDATE_PROFILE)
    Call<BaseModel> updateProfileWithImage(
            @Part(WSConstants.WS_PARAM_JSON) RequestBody description,
            @Part MultipartBody.Part file);

    @Multipart
    @POST(WSConstants.WS_METHOD_UPDATE_PROFILE)
    Call<BaseModel> updateProfile(
            @Part(WSConstants.WS_PARAM_JSON) RequestBody description);
}