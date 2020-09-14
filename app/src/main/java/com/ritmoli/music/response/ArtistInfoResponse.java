package com.ritmoli.music.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ritmoli.music.model.ArtistInfoResponse_Artist;

public class ArtistInfoResponse {
    @SerializedName("artist")
    @Expose
    private ArtistInfoResponse_Artist artist;
    @SerializedName("status")
    @Expose
    private String status;


    public ArtistInfoResponse_Artist getArtist() {
        return artist;
    }

    public void setArtist(ArtistInfoResponse_Artist artist) {
        this.artist = artist;
    }

}
