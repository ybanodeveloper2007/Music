package com.ritmoli.music.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Content {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("popularity")
    @Expose
    private Object popularity;
    @SerializedName("display_name")
    @Expose
    private Object displayName;
    @SerializedName("channelable_id")
    @Expose
    private Integer channelableId;
    @SerializedName("channelable_order")
    @Expose
    private Integer channelableOrder;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
}
