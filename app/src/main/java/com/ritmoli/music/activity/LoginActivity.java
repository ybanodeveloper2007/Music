package com.ritmoli.music.activity;

import androidx.appcompat.app.AppCompatActivity;


import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ritmoli.music.R;
import com.ritmoli.music.fragment.UserSessionManager;
import com.ritmoli.music.response.LoginResponse;
import com.ritmoli.retrofit.ApiInterface;
import com.ritmoli.retrofit.RestManager;
import com.ritmoli.utils.RotateDialog;
import com.ritmoli.utils.StaticUtil;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.Arrays;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int RC_SIGN_IN = 9001;
    GoogleSignInClient mGoogleSignInClient;
    LoginButton loginButton;
    FloatingActionButton floating;
    ProgressDialog progressDialog;
    TextView tvRegister,tvForget;
    private static final String EMAIL = "email";
    CallbackManager callbackManager;
    EditText etEmail,etPassword;
    ProgressBar progressBar;
    private int progressBarStatus = 0;
    private Handler progressBarHandler = new Handler();
    private long fileSize = 0;

    private ApiInterface apiInterface;
    Call<LoginResponse> callLogin;

    // User Session Manager Class
    UserSessionManager session;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String ApiToken = "ApiToken";
    public static final String Email = "emailKey";
    public static final String UserID = "userID";
    public static final String avatar = "avtar";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginlayout);

       // sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        progressDialog = new ProgressDialog(this);
        // User Session Manager
        session = new UserSessionManager(getApplicationContext());

        SignInButton signInButton = findViewById(R.id.Googlelogin_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        findViewById(R.id.Googlelogin_button).setOnClickListener(this);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        //updateUI(account);
        //progress bar...
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        tvRegister = (TextView) findViewById(R.id.txt_Regsiter);
        tvForget = (TextView) findViewById(R.id.txt_forgot_pass);
        etEmail = (EditText) findViewById(R.id.edt_email);
        etPassword = (EditText) findViewById(R.id.edt_password);
        loginButton = (LoginButton) findViewById(R.id.fblogin_button);
        floating = (FloatingActionButton) findViewById(R.id.fab);

        tvRegister.setOnClickListener(this);
        tvForget.setOnClickListener(this);
        floating.setOnClickListener(this);

        loginButton.setReadPermissions(Arrays.asList(EMAIL));
        // If you are using in a fragment, call loginButton.setFragment(this);

        // Callback registration
        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });


        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // App code
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {

        try {

            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            updateUI(account);

        }

        catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            // updateUI(null);
        }
    }

    private void updateUI(GoogleSignInAccount account) {
        Log.d("Sri",""+account.getDisplayName());
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.Googlelogin_button:
                signIn();
                break;

            case R.id.txt_Regsiter:
                register();
                break;

            case R.id.fab:
                String stEmail=etEmail.getText().toString().toLowerCase();
                String stPassword=etPassword.getText().toString().toLowerCase();
                String stRemember="false";
                progressBar.setVisibility(View.VISIBLE);
                progressDialog.setMessage("Loading...");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.setCancelable(false);

                doLoginApiCall();
                break;

            case R.id.txt_forgot_pass:
                forgot();
                break;
        }
    }

    private void doLoginApiCall() {

      /*  RotateDialog.newInstance((Activity) getApplicationContext()).startLoading();*/
        progressDialog.dismiss();
        progressBar.setVisibility(View.GONE);
        Call<ResponseBody> responseBody = RestManager.getInstance().getService()
                // .logIn(etEmail.getText().toString(), etPassword.getText().toString(), token);
                .logIn(etEmail.getText().toString(), etPassword.getText().toString(), "artist","false");

        responseBody.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
              //  RotateDialog.newInstance((Activity) getApplicationContext()).stopLoading();

                try {

                    if (response.isSuccessful()) {
                        String val = response.body().string();
                        JSONObject jsonObject = new JSONObject(val);

                        String status=jsonObject.getString("status");

                    //  JSONObject nestedJsonObjectVal = jsonObject.getJSONObject("user");

                        if (jsonObject.getString("status").equalsIgnoreCase("1")) {

                            String user_id=jsonObject.getString("user_id");

                            session.createUserLoginSession(jsonObject.getString("user_id"));
                            StaticUtil.showToast(LoginActivity.this,jsonObject.getString("msg"));
                            Intent intent =new Intent(getApplicationContext(),WelcomeActivity.class);
                            startActivity(intent);

                        }

                        else {

                            StaticUtil.showToast(LoginActivity.this, "fail");
                        }

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
               // RotateDialog.newInstance((Activity) getApplicationContext()).stopLoading();
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void signIn() {

        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void register (){

        Intent intent =new Intent(getApplicationContext(),RegisterActivity.class);
        startActivity(intent);
    }

    private void forgot (){

        Intent intent =new Intent(getApplicationContext(), ForgetPasswordActivity.class);
        startActivity(intent);
    }

}