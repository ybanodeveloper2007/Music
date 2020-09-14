package com.ritmoli.music.request;

public class CreatePlaylist {
  String  description;
  String  image;
  String  name;
  boolean publicPrivacy;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public boolean isPublicPrivacy() {
        return publicPrivacy;
    }

    public void setPublicPrivacy(boolean publicPrivacy) {
        this.publicPrivacy = publicPrivacy;
    }
}
