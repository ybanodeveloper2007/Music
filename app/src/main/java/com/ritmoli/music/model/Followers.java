package com.ritmoli.music.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Followers {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private Object lastName;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("username")
    @Expose
    private Object username;
    @SerializedName("avatar_url")
    @Expose
    private Object avatarUrl;
    @SerializedName("gender")
    @Expose
    private Object gender;
    @SerializedName("api_token")
    @Expose
    private String apiToken;
    @SerializedName("card_brand")
    @Expose
    private Object cardBrand;
    @SerializedName("card_last_four")
    @Expose
    private Object cardLastFour;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("country")
    @Expose
    private Object country;
    @SerializedName("timezone")
    @Expose
    private Object timezone;
    @SerializedName("stripe_id")
    @Expose
    private Object stripeId;
    @SerializedName("available_space")
    @Expose
    private Object availableSpace;
    @SerializedName("email_verified_at")
    @Expose
    private String emailVerifiedAt;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("has_password")
    @Expose
    private Boolean hasPassword;
    @SerializedName("model_type")
    @Expose
    private String modelType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Object getLastName() {
        return lastName;
    }

    public void setLastName(Object lastName) {
        this.lastName = lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getUsername() {
        return username;
    }

    public void setUsername(Object username) {
        this.username = username;
    }

    public Object getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(Object avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Object getGender() {
        return gender;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public Object getCardBrand() {
        return cardBrand;
    }

    public void setCardBrand(Object cardBrand) {
        this.cardBrand = cardBrand;
    }

    public Object getCardLastFour() {
        return cardLastFour;
    }

    public void setCardLastFour(Object cardLastFour) {
        this.cardLastFour = cardLastFour;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Object getCountry() {
        return country;
    }

    public void setCountry(Object country) {
        this.country = country;
    }

    public Object getTimezone() {
        return timezone;
    }

    public void setTimezone(Object timezone) {
        this.timezone = timezone;
    }

    public Object getStripeId() {
        return stripeId;
    }

    public void setStripeId(Object stripeId) {
        this.stripeId = stripeId;
    }

    public Object getAvailableSpace() {
        return availableSpace;
    }

    public void setAvailableSpace(Object availableSpace) {
        this.availableSpace = availableSpace;
    }

    public String getEmailVerifiedAt() {
        return emailVerifiedAt;
    }

    public void setEmailVerifiedAt(String emailVerifiedAt) {
        this.emailVerifiedAt = emailVerifiedAt;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Boolean getHasPassword() {
        return hasPassword;
    }

    public void setHasPassword(Boolean hasPassword) {
        this.hasPassword = hasPassword;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

}
