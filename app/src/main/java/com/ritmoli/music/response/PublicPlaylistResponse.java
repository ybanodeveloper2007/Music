package com.ritmoli.music.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ritmoli.music.model.PublicPlayListPagination;

public class PublicPlaylistResponse {
    @SerializedName("pagination")
    @Expose
    private PublicPlayListPagination pagination;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("seo")
    @Expose
    private Object seo;

    public PublicPlayListPagination getPagination() {
        return pagination;
    }

    public void setPagination(PublicPlayListPagination pagination) {
        this.pagination = pagination;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getSeo() {
        return seo;
    }

    public void setSeo(Object seo) {
        this.seo = seo;
    }

}