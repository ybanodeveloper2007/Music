package com.ritmoli.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {

    @FormUrlEncoded
    @POST(Constant.SIGNUP_END_POINT)
    Call<ResponseBody> signUp(@Field(Constant.SignUp.NAME) String name,
                              @Field(Constant.SignUp.Lname) String lName,
                              @Field(Constant.SignUp.EMAIL) String email,
                              @Field(Constant.SignUp.PASSWORD) String password,
                              @Field(Constant.SignUp.USERNAME) String username,
                              @Field(Constant.SignUp.USERTYPE)String userType);
    @FormUrlEncoded
    @POST(Constant.LOGIN_END_POINT)
    Call<ResponseBody> logIn(@Field(Constant.SignUp.EMAIL) String email,
                              @Field(Constant.SignUp.PASSWORD) String password,
                              @Field(Constant.SignUp.USERTYPE) String userType,
                              @Field(Constant.SignUp.Remember)String remember);

    @FormUrlEncoded
    @POST(Constant.PASSWORD_CHANGE_END_POINT)
    Call<ResponseBody> PasswordChange(@Field(Constant.ChangePassword.USERID) String userID,
                             @Field(Constant.ChangePassword.CURRENT_PWD) String Cur_pwd,
                             @Field(Constant.ChangePassword.NEW_PASSWORD) String new_pwd,
                             @Field(Constant.ChangePassword.RE_PASSWORD)String new_rep_pwd);

    @FormUrlEncoded
    @POST(Constant.LOGOUT_END_POINT)
    Call<ResponseBody> logOut(@Field(Constant.PROFILE.id) String userID);


    @FormUrlEncoded
    @POST(Constant.FORGET_END_POINT)
    Call<ResponseBody> forgetPassword(@Field(Constant.ForgotPassword.EMAIL) String email);

    @FormUrlEncoded
    @POST(Constant.PROFILE_END_POINT)
    Call<ResponseBody> getProfile(@Field(Constant.PROFILE.id) String userId);

    @FormUrlEncoded
    @POST(Constant.PROFILE_END_POINT)
    Call<ResponseBody> getPAvatar();

  /*  @FormUrlEncoded
    @POST(Constant.MY_PLAYLIST_API)
    Call<ResponseBody> playList(@Field(Constant.PlayLIST.page) String page);*/

    @POST("auth/register")
    @FormUrlEncoded
    Call<ResponseBody> register(@Field("username") String username, @Field("email") String email, @Field("password") String password);

   /* @POST("login.php")
    @FormUrlEncoded
    Call<ResponseBody> login(@Field("username") String username, @Field("password") String password);

    Call<ResponseBody> getLoginn(String toString, String toString1, String aFalse);*/
}


