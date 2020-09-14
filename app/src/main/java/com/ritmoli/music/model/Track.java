package com.ritmoli.music.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Track {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("album_name")
    @Expose
    private String albumName;
    @SerializedName("album_id")
    @Expose
    private Integer albumId;
    @SerializedName("number")
    @Expose
    private Integer number;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("youtube_id")
    @Expose
    private Object youtubeId;
    @SerializedName("spotify_popularity")
    @Expose
    private Integer spotifyPopularity;
    @SerializedName("url")
    @Expose
    private Object url;
    @SerializedName("plays")
    @Expose
    private Integer plays;
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
    @SerializedName("user_id")
    @Expose
    private Object userId;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("image")
    @Expose
    private Object image;
    @SerializedName("model_type")
    @Expose
    private String modelType;
    @SerializedName("created_at_relative")
    @Expose
    private Object createdAtRelative;
    @SerializedName("artists")
    @Expose
    private List<Artist__> artists = null;

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

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Object getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(Object youtubeId) {
        this.youtubeId = youtubeId;
    }

    public Integer getSpotifyPopularity() {
        return spotifyPopularity;
    }

    public void setSpotifyPopularity(Integer spotifyPopularity) {
        this.spotifyPopularity = spotifyPopularity;
    }

    public Object getUrl() {
        return url;
    }

    public void setUrl(Object url) {
        this.url = url;
    }

    public Integer getPlays() {
        return plays;
    }

    public void setPlays(Integer plays) {
        this.plays = plays;
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

    public Object getUserId() {
        return userId;
    }

    public void setUserId(Object userId) {
        this.userId = userId;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
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

    public List<Artist__> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist__> artists) {
        this.artists = artists;
    }

}
