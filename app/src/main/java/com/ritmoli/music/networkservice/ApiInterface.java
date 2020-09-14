package com.ritmoli.music.networkservice;

import com.ritmoli.music.request.CreatePlaylist;
import com.ritmoli.music.response.ArtistInfoResponse;
import com.ritmoli.music.response.ArtistResponse;
import com.ritmoli.music.response.CreatePlaylistResponse;
import com.ritmoli.music.response.DiscoverResponse;
import com.ritmoli.music.response.FollowResponse;
import com.ritmoli.music.response.FollowersResponse;
import com.ritmoli.music.response.PublicPlaylistResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {



    @GET("artists")
    Call<ArtistResponse> getArtist(@Query("orderBy") String orderBy);

    @GET("channel/discover")
    Call<DiscoverResponse> getDiscover();

    @GET("user-profile/28/load-more/followers")
    Call<FollowersResponse> getFollowers(@Query("page") String page);

    @POST("users/{user_id}/follow")
    Call<FollowResponse> follow(@Path(value = "user_id") String userId);

    @POST("users/{user_id}/unfollow")
    Call<FollowResponse> unfollow(@Path(value = "user_id") String userId);

    @GET("artists/{artist_id}/")
    Call<ArtistInfoResponse> getArtistInfo(@Path(value = "artist_id") String artist_id,@Query("simplified") String simplified);

    @GET("playlists")
    Call<PublicPlaylistResponse> getPublicPlaylist(@Query("public") String publicId);

    @POST("playlists")
    Call<CreatePlaylistResponse> createPlaylist(@Body CreatePlaylist createPlaylist);

}