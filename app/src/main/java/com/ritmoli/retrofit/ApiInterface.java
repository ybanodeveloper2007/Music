package com.ritmoli.retrofit;

import com.ritmoli.music.response.ArtistResponse;
import com.ritmoli.music.response.DiscoverResponse;
import com.ritmoli.music.response.LoginResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("auth/login")
    public Call<LoginResponse> getLogin(@Query("email") String email,
                                        @Query("password") String password,
                                        @Query("remember") String remember);

    @POST("auth/login")
    public Call<ResponseBody> getLoginn(@Query("email") String email,
                                        @Query("password") String password,
                                        @Query("remember") String remember);

    @GET("/artists")
    Call<ArtistResponse> getArtist(@Query("orderBy") String orderBy);

    @GET("/playlists")
    Call<ArtistResponse> getPublicPlayList(@Query("page") String page);

    @GET("channel")
    public Call<DiscoverResponse> getDiscover();
}
