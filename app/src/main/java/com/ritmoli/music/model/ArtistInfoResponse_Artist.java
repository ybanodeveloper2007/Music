package com.ritmoli.music.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArtistInfoResponse_Artist extends Artist {

    @Expose
    private List<Album> albums = null;
    @SerializedName("genres")
    @Expose
    private List<Object> genres = null;
    @SerializedName("bio")
    @Expose
    private Object bio;
    @SerializedName("bio_images")
    @Expose
    private List<Object> bioImages = null;


    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public List<Object> getGenres() {
        return genres;
    }

    public void setGenres(List<Object> genres) {
        this.genres = genres;
    }

    public Object getBio() {
        return bio;
    }

    public void setBio(Object bio) {
        this.bio = bio;
    }

    public List<Object> getBioImages() {
        return bioImages;
    }

    public void setBioImages(List<Object> bioImages) {
        this.bioImages = bioImages;
    }

}

