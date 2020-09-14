package com.ritmoli.music.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ritmoli.music.model.ArtistResponse_Pagination;

public class ArtistResponse {

    @SerializedName("pagination")
    @Expose
    private ArtistResponse_Pagination artistResponsePagination;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("seo")
    @Expose
    private Object seo;

    public ArtistResponse_Pagination getArtistResponsePagination() {
        return artistResponsePagination;
    }

    public void setArtistResponsePagination(ArtistResponse_Pagination artistResponsePagination) {
        this.artistResponsePagination = artistResponsePagination;
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


