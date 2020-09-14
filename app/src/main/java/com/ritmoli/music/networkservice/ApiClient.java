package com.ritmoli.music.networkservice;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
   public static final String BASE_URL = "http://40.88.53.64/ritmoli/secure/";
    public static Retrofit retrofit = null;

    public static Retrofit getApiClient(){
        if (retrofit == null){
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(logging);
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                    client(httpClient.build()).
                    addConverterFactory(GsonConverterFactory.create(gson)).build();
        }
        return retrofit;
    }
}
