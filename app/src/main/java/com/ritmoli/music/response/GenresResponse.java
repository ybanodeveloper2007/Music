package com.ritmoli.music.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ritmoli.music.model.Genre;
import com.ritmoli.music.model.GenresResponse_Artists;

public class GenresResponse {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("genre")
    @Expose
    private Genre genre;
    @SerializedName("artists")
    @Expose
    private GenresResponse_Artists artists;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public GenresResponse_Artists getArtists() {
        return artists;
    }

    public void setArtists(GenresResponse_Artists artists) {
        this.artists = artists;
    }

}
