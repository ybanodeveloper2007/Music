package com.ritmoli.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DiscoverChannel {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("content_type")
    @Expose
    private String contentType;
    @SerializedName("auto_update")
    @Expose
    private Object autoUpdate;
    @SerializedName("layout")
    @Expose
    private Object layout;
    @SerializedName("hide_title")
    @Expose
    private Boolean hideTitle;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("seo_title")
    @Expose
    private String seoTitle;
    @SerializedName("seo_description")
    @Expose
    private String seoDescription;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("model_type")
    @Expose
    private String modelType;
    @SerializedName("content")
    @Expose
    private List<CateogoryContent> content = null;

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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Object getAutoUpdate() {
        return autoUpdate;
    }

    public void setAutoUpdate(Object autoUpdate) {
        this.autoUpdate = autoUpdate;
    }

    public Object getLayout() {
        return layout;
    }

    public void setLayout(Object layout) {
        this.layout = layout;
    }

    public Boolean getHideTitle() {
        return hideTitle;
    }

    public void setHideTitle(Boolean hideTitle) {
        this.hideTitle = hideTitle;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSeoTitle() {
        return seoTitle;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }

    public String getSeoDescription() {
        return seoDescription;
    }

    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription;
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

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public List<CateogoryContent> getContent() {
        return content;
    }

    public void setContent(List<CateogoryContent> content) {
        this.content = content;
    }
}
