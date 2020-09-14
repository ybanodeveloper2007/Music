package com.ritmoli.music.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryInformation {
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
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("artist_type")
    @Expose
    private String artistType;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("channelable_id")
    @Expose
    private Integer channelableId;
    @SerializedName("channelable_order")
    @Expose
    private Integer channelableOrder;
    @SerializedName("model_type")
    @Expose
    private String modelType;
    @SerializedName("created_at_relative")
    @Expose
    private Object createdAtRelative;
    @SerializedName("artist")
    @Expose
    private Artist1 artist;
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
    @SerializedName("url")
    @Expose
    private Object url;
    @SerializedName("plays")
    @Expose
    private Integer plays;
    @SerializedName("user_id")
    @Expose
    private Object userId;
    @SerializedName("plays_count")
    @Expose
    private Integer playsCount;
    @SerializedName("album")
    @Expose
    private Album album;
    @SerializedName("artists")
    @Expose
    private List<Artist__> artists = null;
    @SerializedName("genres")
    @Expose
    private List<Object> genres = null;
    @SerializedName("popularity")
    @Expose
    private Object popularity;
    @SerializedName("display_name")
    @Expose
    private Object displayName;

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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
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

    public Integer getChannelableId() {
        return channelableId;
    }

    public void setChannelableId(Integer channelableId) {
        this.channelableId = channelableId;
    }

    public Integer getChannelableOrder() {
        return channelableOrder;
    }

    public void setChannelableOrder(Integer channelableOrder) {
        this.channelableOrder = channelableOrder;
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

    public Artist1 getArtist() {
        return artist;
    }

    public void setArtist(Artist1 artist) {
        this.artist = artist;
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

    public Object getUserId() {
        return userId;
    }

    public void setUserId(Object userId) {
        this.userId = userId;
    }

    public Integer getPlaysCount() {
        return playsCount;
    }

    public void setPlaysCount(Integer playsCount) {
        this.playsCount = playsCount;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public List<Artist__> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist__> artists) {
        this.artists = artists;
    }

    public List<Object> getGenres() {
        return genres;
    }

    public void setGenres(List<Object> genres) {
        this.genres = genres;
    }

    public Object getPopularity() {
        return popularity;
    }

    public void setPopularity(Object popularity) {
        this.popularity = popularity;
    }

    public Object getDisplayName() {
        return displayName;
    }

    public void setDisplayName(Object displayName) {
        this.displayName = displayName;
    }


}
