package com.ritmoli.music.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Album {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("artist_id")
    @Expose
    private Integer artistId;
    @SerializedName("spotify_popularity")
    @Expose
    private Object spotifyPopularity;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("auto_update")
    @Expose
    private Boolean autoUpdate;
    @SerializedName("local_only")
    @Expose
    private Boolean localOnly;
    @SerializedName("spotify_id")
    @Expose
    private String spotifyId;
    @SerializedName("created_at")
    @Expose
    private Object createdAt;
    @SerializedName("updated_at")
    @Expose
    private Object updatedAt;
    @SerializedName("artist_type")
    @Expose
    private String artistType;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("model_type")
    @Expose
    private String modelType;
    @SerializedName("created_at_relative")
    @Expose
    private Object createdAtRelative;
    @SerializedName("artist")
    @Expose
    private Artist_ artist;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public Object getSpotifyPopularity() {
        return spotifyPopularity;
    }

    public void setSpotifyPopularity(Object spotifyPopularity) {
        this.spotifyPopularity = spotifyPopularity;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Boolean getAutoUpdate() {
        return autoUpdate;
    }

    public void setAutoUpdate(Boolean autoUpdate) {
        this.autoUpdate = autoUpdate;
    }

    public Boolean getLocalOnly() {
        return localOnly;
    }

    public void setLocalOnly(Boolean localOnly) {
        this.localOnly = localOnly;
    }

    public String getSpotifyId() {
        return spotifyId;
    }

    public void setSpotifyId(String spotifyId) {
        this.spotifyId = spotifyId;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getArtistType() {
        return artistType;
    }

    public void setArtistType(String artistType) {
        this.artistType = artistType;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public Object getCreatedAtRelative() {
        return createdAtRelative;
    }

    public void setCreatedAtRelative(Object createdAtRelative) {
        this.createdAtRelative = createdAtRelative;
    }

    public Artist_ getArtist() {
        return artist;
    }

    public void setArtist(Artist_ artist) {
        this.artist = artist;
    }

}
