package com.ritmoli.music.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArtistResponse_Artist implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("spotify_followers")
    @Expose
    private Integer spotifyFollowers;
    @SerializedName("spotify_popularity")
    @Expose
    private Integer spotifyPopularity;
    @SerializedName("image_small")
    @Expose
    private String imageSmall;
    @SerializedName("image_large")
    @Expose
    private String imageLarge;
    @SerializedName("updated_at")
    @Expose
    private Object updatedAt;
    @SerializedName("bio_legacy")
    @Expose
    private Object bioLegacy;
    @SerializedName("wiki_image_large")
    @Expose
    private Object wikiImageLarge;
    @SerializedName("wiki_image_small")
    @Expose
    private Object wikiImageSmall;
    @SerializedName("created_at")
    @Expose
    private Object createdAt;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("auto_update")
    @Expose
    private Boolean autoUpdate;
    @SerializedName("spotify_id")
    @Expose
    private String spotifyId;
    @SerializedName("albums_count")
    @Expose
    private Integer albumsCount;
    @SerializedName("model_type")
    @Expose
    private String modelType;

    protected ArtistResponse_Artist(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        name = in.readString();
        if (in.readByte() == 0) {
            spotifyFollowers = null;
        } else {
            spotifyFollowers = in.readInt();
        }
        if (in.readByte() == 0) {
            spotifyPopularity = null;
        } else {
            spotifyPopularity = in.readInt();
        }
        imageSmall = in.readString();
        imageLarge = in.readString();
        if (in.readByte() == 0) {
            views = null;
        } else {
            views = in.readInt();
        }
        byte tmpAutoUpdate = in.readByte();
        autoUpdate = tmpAutoUpdate == 0 ? null : tmpAutoUpdate == 1;
        spotifyId = in.readString();
        if (in.readByte() == 0) {
            albumsCount = null;
        } else {
            albumsCount = in.readInt();
        }
        modelType = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(name);
        if (spotifyFollowers == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(spotifyFollowers);
        }
        if (spotifyPopularity == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(spotifyPopularity);
        }
        dest.writeString(imageSmall);
        dest.writeString(imageLarge);
        if (views == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(views);
        }
        dest.writeByte((byte) (autoUpdate == null ? 0 : autoUpdate ? 1 : 2));
        dest.writeString(spotifyId);
        if (albumsCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(albumsCount);
        }
        dest.writeString(modelType);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ArtistResponse_Artist> CREATOR = new Creator<ArtistResponse_Artist>() {
        @Override
        public ArtistResponse_Artist createFromParcel(Parcel in) {
            return new ArtistResponse_Artist(in);
        }

        @Override
        public ArtistResponse_Artist[] newArray(int size) {
            return new ArtistResponse_Artist[size];
        }
    };

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

    public Integer getSpotifyFollowers() {
        return spotifyFollowers;
    }

    public void setSpotifyFollowers(Integer spotifyFollowers) {
        this.spotifyFollowers = spotifyFollowers;
    }

    public Integer getSpotifyPopularity() {
        return spotifyPopularity;
    }

    public void setSpotifyPopularity(Integer spotifyPopularity) {
        this.spotifyPopularity = spotifyPopularity;
    }

    public String getImageSmall() {
        return imageSmall;
    }

    public void setImageSmall(String imageSmall) {
        this.imageSmall = imageSmall;
    }

    public String getImageLarge() {
        return imageLarge;
    }

    public void setImageLarge(String imageLarge) {
        this.imageLarge = imageLarge;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getBioLegacy() {
        return bioLegacy;
    }

    public void setBioLegacy(Object bioLegacy) {
        this.bioLegacy = bioLegacy;
    }

    public Object getWikiImageLarge() {
        return wikiImageLarge;
    }

    public void setWikiImageLarge(Object wikiImageLarge) {
        this.wikiImageLarge = wikiImageLarge;
    }

    public Object getWikiImageSmall() {
        return wikiImageSmall;
    }

    public void setWikiImageSmall(Object wikiImageSmall) {
        this.wikiImageSmall = wikiImageSmall;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Boolean getAutoUpdate() {
        return autoUpdate;
    }

    public void setAutoUpdate(Boolean autoUpdate) {
        this.autoUpdate = autoUpdate;
    }

    public String getSpotifyId() {
        return spotifyId;
    }

    public void setSpotifyId(String spotifyId) {
        this.spotifyId = spotifyId;
    }

    public Integer getAlbumsCount() {
        return albumsCount;
    }

    public void setAlbumsCount(Integer albumsCount) {
        this.albumsCount = albumsCount;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }
}
