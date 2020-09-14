package com.ritmoli.retrofit;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mobile08 on 3/20/2017.
 */

public class RestManager {

    private static final RestManager ourInstance = new RestManager();

    public static RestManager getInstance() {
        return ourInstance;
    }

    private RestManager() {
    }

    private APIService aPIService;

    public APIService getService() {
        if (aPIService == null) {

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
// set your desired log level
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient httpClient = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .connectTimeout(500, TimeUnit.SECONDS)
                    .readTimeout(500, TimeUnit.SECONDS)
                    .writeTimeout(500, TimeUnit.SECONDS)
                    .build();
// add your other interceptors …

// add logging as last interceptor
//            httpClient.addInterceptor(logging);  // <-- this is the important line!

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.URL_API)
                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            aPIService = retrofit.create(APIService.class);
        }
        return aPIService;
    }


    public APIService getService(String baseUrl) {
        if (aPIService == null) {

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
// set your desired log level
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient httpClient = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .connectTimeout(500, TimeUnit.SECONDS)
                    .readTimeout(500, TimeUnit.SECONDS)
                    .writeTimeout(500, TimeUnit.SECONDS)
                    .build();
// add your other interceptors …

// add logging as last interceptor
//            httpClient.addInterceptor(logging);  // <-- this is the important line!

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            aPIService = retrofit.create(APIService.class);
        }
        return aPIService;
    }

   /* public  boolean checkInternetConnection(Context context) {
        System.out.println("Internet////////////////////");


        ConnectivityManager conMgr = (ConnectivityManager)context.getSystemService
                (Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork=conMgr.getActiveNetworkInfo();

        System.out.println("Value....................n"+activeNetwork);
        if (conMgr.getActiveNetworkInfo() != null && conMgr.getActiveNetworkInfo().isAvailable() &&
                conMgr.getActiveNetworkInfo().isConnected()) {
            System.out.println("returnInternet////////////////////");
            return true;
        } else {
            System.out.println("returnInternet////////////////////");

            System.out.println("Internet Connection Not Present");
            return false;
        }


    }*/
}
