package com.ritmoli.model;

import java.util.ArrayList;

/**
 * Created by user on 1/16/2018.
 */

public class PlayListModel {

    private String id = "";
    private String name = "";
    private String publicCount = "";
    private String created_at = "";
    private String updated_at = "";
    private String image = "";
    private String description = "";
    private String views = "";
    private String tracks_count = "";
    private String model_type = "";

    private ArrayList<Track> tracks = new ArrayList<>();

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public void setTracks(ArrayList<Track> tracks) {
        this.tracks = tracks;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublicCount() {
        return publicCount;
    }

    public void setPublicCount(String publicCount) {
        this.publicCount = publicCount;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getTracks_count() {
        return tracks_count;
    }

    public void setTracks_count(String tracks_count) {
        this.tracks_count = tracks_count;
    }

    public String getModel_type() {
        return model_type;
    }

    public void setModel_type(String model_type) {
        this.model_type = model_type;
    }

}

