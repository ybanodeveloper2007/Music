package com.ritmoli.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Artist {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("spotify_followers")
    @Expose
    private Integer spotifyFollowers;
    @SerializedName("spotify_popularity")
    @Expose
    private Integer spotifyPopularity;
    @SerializedName("image_small")
    @Expose
    private String imageSmall;
    @SerializedName("image_large")
    @Expose
    private String imageLarge;
    @SerializedName("updated_at")
    @Expose
    private Object updatedAt;
    @SerializedName("bio_legacy")
    @Expose
    private Object bioLegacy;
    @SerializedName("wiki_image_large")
    @Expose
    private Object wikiImageLarge;
    @SerializedName("wiki_image_small")
    @Expose
    private Object wikiImageSmall;
    @SerializedName("created_at")
    @Expose
    private Object createdAt;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("auto_update")
    @Expose
    private Boolean autoUpdate;
    @SerializedName("spotify_id")
    @Expose
    private String spotifyId;
    @SerializedName("albums_count")
    @Expose
    private Integer albumsCount;
    @SerializedName("model_type")
    @Expose
    private String modelType;

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

    public Integer getSpotifyFollowers() {
        return spotifyFollowers;
    }

    public void setSpotifyFollowers(Integer spotifyFollowers) {
        this.spotifyFollowers = spotifyFollowers;
    }

    public Integer getSpotifyPopularity() {
        return spotifyPopularity;
    }

    public void setSpotifyPopularity(Integer spotifyPopularity) {
        this.spotifyPopularity = spotifyPopularity;
    }

    public String getImageSmall() {
        return imageSmall;
    }

    public void setImageSmall(String imageSmall) {
        this.imageSmall = imageSmall;
    }

    public String getImageLarge() {
        return imageLarge;
    }

    public void setImageLarge(String imageLarge) {
        this.imageLarge = imageLarge;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getBioLegacy() {
        return bioLegacy;
    }

    public void setBioLegacy(Object bioLegacy) {
        this.bioLegacy = bioLegacy;
    }

    public Object getWikiImageLarge() {
        return wikiImageLarge;
    }

    public void setWikiImageLarge(Object wikiImageLarge) {
        this.wikiImageLarge = wikiImageLarge;
    }

    public Object getWikiImageSmall() {
        return wikiImageSmall;
    }

    public void setWikiImageSmall(Object wikiImageSmall) {
        this.wikiImageSmall = wikiImageSmall;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
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

    public String getSpotifyId() {
        return spotifyId;
    }

    public void setSpotifyId(String spotifyId) {
        this.spotifyId = spotifyId;
    }

    public Integer getAlbumsCount() {
        return albumsCount;
    }

    public void setAlbumsCount(Integer albumsCount) {
        this.albumsCount = albumsCount;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }


}
