package com.ritmoli.music.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ritmoli.music.model.Followers_Pagination;

public class FollowersResponse {
    @SerializedName("pagination")
    @Expose
    private Followers_Pagination pagination;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("seo")
    @Expose
    private Object seo;

    public Followers_Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Followers_Pagination pagination) {
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
