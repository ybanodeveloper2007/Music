package com.ritmoli.music.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArtistInfoResponse_Album extends Album {
    @SerializedName("artist")
    @Expose
    private Artist_ artist;

    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;
    @SerializedName("genres")
    @Expose
    private List<Object> genres = null;
    @SerializedName("tracks")
    @Expose
    private List<Track> tracks = null;


    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public List<Object> getGenres() {
        return genres;
    }

    public void setGenres(List<Object> genres) {
        this.genres = genres;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    @Override
    public Artist_ getArtist() {
        return artist;
    }

    @Override
    public void setArtist(Artist_ artist) {
        this.artist = artist;
    }


}
