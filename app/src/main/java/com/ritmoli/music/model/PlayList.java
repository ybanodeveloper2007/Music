package com.ritmoli.music.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlayList {@SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("public")
    @Expose
    private Integer _public;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("image")
    @Expose
    private Object image;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("tracks_count")
    @Expose
    private Integer tracksCount;
    @SerializedName("model_type")
    @Expose
    private String modelType;
    @SerializedName("tracks")
    @Expose
    private List<Track> tracks = null;
    @SerializedName("editors")
    @Expose
    private List<Editor> editors = null;

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

    public Integer getPublic() {
        return _public;
    }

    public void setPublic(Integer _public) {
        this._public = _public;
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

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getTracksCount() {
        return tracksCount;
    }

    public void setTracksCount(Integer tracksCount) {
        this.tracksCount = tracksCount;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public List<Editor> getEditors() {
        return editors;
    }

    public void setEditors(List<Editor> editors) {
        this.editors = editors;
    }

}
