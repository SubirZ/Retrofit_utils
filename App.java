package com.example.retofit;

import android.app.Application;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * application class for retrofit demo
 */
public class App extends Application {
    private static App mAppInstance;
    private static WsCallback retrofitInstance;

    public static App getInstance() {
        return mAppInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppInstance = this;

        updateRetrofitInstance(false);
    }

    public static void updateRetrofitInstance(boolean isLoggedIn) {
        WSUtils client;
        if (!isLoggedIn) {
            client = new WSUtils();
        } else {
            client = new WSUtils(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {

                    Request.Builder builder = chain.request().newBuilder();
                    builder.addHeader(Constants.HEADER_AUTH, "Bearer " + Preference.getInstance().mSharedPreferences.getString(Preference.PREFERENCE_TOKEN, ""));
                    Request request = builder.build();

                    return chain.proceed(request);
                }
            });
        }
        retrofitInstance = client.getInstance();
    }

    public static WsCallback getRetrofitInstance() {
        return retrofitInstance;
    }

}