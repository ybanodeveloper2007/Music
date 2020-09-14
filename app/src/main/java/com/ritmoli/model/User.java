package com.ritmoli.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("first_name")
    @Expose
    private String first_name;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("api_token")
    @Expose
    private String api_token;

    @SerializedName("language")
    @Expose
    private String language;

    @SerializedName("avatar")
    @Expose
    private String avatar;

    @SerializedName("display_name")
    @Expose
    private String display_name;

    @SerializedName("model_type")
    @Expose
    private String model_type;

}
