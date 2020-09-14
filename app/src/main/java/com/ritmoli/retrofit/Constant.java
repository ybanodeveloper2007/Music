package com.ritmoli.retrofit;

/**
 * Created by mobile08 on 3/20/2017.
 */

public class Constant {

  //  public static final String URL_API = "http://40.88.53.64/ritmoli/secure/";

    public static final String URL_API = "https://ritmoli.com/secure/";
    public static final String LOGIN_END_POINT = "auth/apilogin";
    public static final String LOGOUT_END_POINT = "auth/apilogout";
    public static final String FORGET_END_POINT = "auth/password/email";
    public static final String PASSWORD_CHANGE_END_POINT = "users/password/change";
    public static final String PROFILE_END_POINT = "users/apigetuser_profile";
    public static final String PROFILE_UPDATE_END_POINT = "users/user_profile_updateapi";
    public static final String P_AVATAR_END_POINT = "user-profile/";
    public static final String SIGNUP_END_POINT = "auth/apiregister";
    public static final String MY_PLAYLIST_API="http://40.88.53.64/ritmoli/secure/playlists?page=1";
    public static final String PUBLIC_PLAYLIST_API="playlists";
    public static final String PLAYLIST_SONG_API="playlists/4";
    public static final String CATEGORY_END_POINT = "category.php";

    interface SignUp {

        String  NAME = "first_name", Lname="last_name", USERNAME = "username", EMAIL = "email", PASSWORD = "password",PASSWORD_CONFIRM="password_confirmation",PURCHASE_CODE="purchase_code",
                DEVICE_ID="ios_device_id",SERVER_KEY="server_key",Remember="remember" ,USERTYPE="user_type";
    }

    interface Password {

        String  NAME = "first_name",  USERNAME = "username", EMAIL = "email", PASSWORD = "password",PASSWORD_CONFIRM="password_confirmation",PURCHASE_CODE="purchase_code",
                DEVICE_ID="ios_device_id",SERVER_KEY="server_key",Remember="remember" ,
                USERTYPE="user_type",Cuurent_PWD="current_password",ACCESS_TOKEN="access_token",
                NEW_PAASSWWORD="new_password",New_CONFIRM_PWD="new_password_confirmation";

    }

    interface ForgotPassword {
        String EMAIL = "email";
    }

    interface ChangePassword {
        String USERID = "user_id";
        String CURRENT_PWD = "current_password";
        String NEW_PASSWORD = "new_password";
        String RE_PASSWORD = "new_password_confirmation";
    }

    interface PROFILE {
        String id = "user_id";
    }

    interface Otp {
        String EMAIL = "email", OTP = "otp";
    }

    interface  Sms{
        String PHONE_NO="phone_no";
    }

    /*interface ChangePassword {
        String EMAIL = "email", PASSWORD = "password", CONFIRM_PASSWORD = "confirm_password";
    }*/

    interface SocialSignUp {
        String EMAIL = "email", PASSWORD = "password", GENDER = "gender", PHONE_NO = "phone_no",
                OAUTH_UID = "oauth_uid", OAUTH_PROVIDER = "oauth_provider";
    }


    interface mEditProfile {
        String FIRST_NAME = "first_name";
        String LAST_NAME = "last_name";
        String EMAIL = "email";
        String DOB = "dob";
        String MOBILE_NUMBER = "mobile_number";
        String LOCATION = "location";
        String BIO = "bio";
        String GENDER = "gender";
        String USER_ID = "user_id";
        String PASSWORD ="password";
    }

    interface mNotification{
        String USER_ID="user_id";
        String USER_TYPE="user_type";
        String TOKEN="token";
    }

    interface mSearchterm{
        String CATEGORY="category";
        String SEARCH_TERM="search_term";
        String PAGE="page";
    }
}