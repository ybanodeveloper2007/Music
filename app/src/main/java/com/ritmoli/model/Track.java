package com.ritmoli.model;

public class Track {

    public String id = "", name = "",album_name,album_id,number,duration,youtube_id,spotify_popularity;
    public String url,plays,auto_update,local_only,spotify_id,created_at,updated_at,model_type,image;


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

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String v) {
        this.album_name = album_name;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getYoutube_id() {
        return youtube_id;
    }

    public void setYoutube_id(String youtube_id) {
        this.youtube_id = youtube_id;
    }

    public String getSpotify_popularity() {
        return spotify_popularity;
    }

    public void setSpotify_popularity(String spotify_popularity) {
        this.spotify_popularity = spotify_popularity;
    }

    public String getSpotify_id() {
        return spotify_id;
    }

    public void setSpotify_id(String spotify_id) {
        this.spotify_id = spotify_id;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String getModel_type() {
        return model_type;
    }

    public void setModel_type(String model_type) {
        this.model_type = model_type;
    }
    
}
