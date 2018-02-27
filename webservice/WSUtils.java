package com.example.retrofit.webservice;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.retrofit.BuildConfig;
import com.example.retrofit.model.BaseModel;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * WSUtils initialization and network calling using retrofit.
 */
public class WSUtils {
    private WsCallback instance;

    public WSUtils() {
        instance = getRetrofit(null).create(WsCallback.class);
    }


    public WSUtils(Interceptor interceptor) {
        instance = getRetrofit(interceptor).create(WsCallback.class);
    }

    private Retrofit getRetrofit(Interceptor interceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(WSConstants.WS_CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(WSConstants.WS_READ_TIMEOUT, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
            logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(logInterceptor);
        }

        if (interceptor != null) {
            builder.addInterceptor(interceptor);
        }

        OkHttpClient client = builder.build();

        return new Retrofit.Builder()
                .baseUrl(WSConstants.WS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    public WsCallback getInstance() {
        return instance;
    }

    public static boolean checkStatus(BaseModel baseModel) {
        if (baseModel != null) {
            if (baseModel.getStatus().equals("SUCCESS")) {
                return true;
            }
        }
        return false;
    }

    public static MultipartBody.Part getFileMultiPart(final String partName, final File file) {

        if (file == null) {
            return null;
        } else {
            // create RequestBody instance from file
            RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), file);

            // MultipartBody.Part is used to send also the actual file name
            return MultipartBody.Part.createFormData(partName, file.getName(), requestFile);
        }
    }

    public static RequestBody getDataMultiPart(final String data) {
        // add another part within the multipart request
        RequestBody description = RequestBody.create(MultipartBody.FORM, data);

        return description;
    }
}