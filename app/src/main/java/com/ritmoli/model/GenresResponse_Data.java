package com.ritmoli.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenresResponse_Data {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("artist_type")
    @Expose
    private String artistType;
    @SerializedName("model_type")
    @Expose
    private String modelType;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArtistType() {
        return artistType;
    }

    public void setArtistType(String artistType) {
        this.artistType = artistType;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
