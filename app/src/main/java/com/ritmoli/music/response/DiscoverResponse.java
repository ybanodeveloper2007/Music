package com.ritmoli.music.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ritmoli.music.model.DiscoverChannel;

public class DiscoverResponse {
    @SerializedName("channel")
    @Expose
    private DiscoverChannel channel;
    @SerializedName("status")
    @Expose
    private String status;

    public DiscoverChannel getChannel() {
        return channel;
    }

    public void setChannel(DiscoverChannel channel) {
        this.channel = channel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
