package com.ritmoli.music.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.ritmoli.model.PlayListModel;
import com.ritmoli.music.R;
import com.ritmoli.music.fragment.UserSessionManager;
import com.ritmoli.preference.MyPreference;
import com.ritmoli.preference.PaperConstant;
import com.ritmoli.retrofit.RestManager;
import com.ritmoli.utils.StaticUtil;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edittxt_email, editText_username,edittxt_password,edittxt_username,edittxt_con_password, edittxt_fname,edittxt_lname,edittxt_address,edittxt_city,edittxt_state,edittxt_pincode, edittxt_confirmpassword;
    TextView btn_login;
    Button btnSignup;
    String token;
    SharedPreferences sp;
    String device_id;
    SharedPreferences.Editor editor;
    UserSessionManager session;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerlayout);

        session = new UserSessionManager(getApplicationContext());

        device_id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        edittxt_fname=(EditText)findViewById(R.id.edt_firstname);
        edittxt_lname=(EditText)findViewById(R.id.edt_lastname);
        edittxt_email=(EditText)findViewById(R.id.edt_email);
        edittxt_username=(EditText)findViewById(R.id.edt_username);
        edittxt_password=(EditText)findViewById(R.id.edt_password);

        btnSignup=(Button)findViewById(R.id.SignInButton);
        btn_login=(TextView)findViewById(R.id.Sign);

        clickEvent();

    }

    public void clickEvent() {

        btnSignup.setOnClickListener(this);
        btn_login.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.SignInButton:
                registerButtonClickProcess();
                break;

            case R.id.Sign:
               // registerButtonClickProcess();
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                break;
        }
    }

    private void registerButtonClickProcess() {

            if (validated()) {
                progressBar.setVisibility(View.VISIBLE);

                doSignUpApiCall();
            }

    }

    private boolean validated() {

        if (edittxt_fname.getText().toString().trim().equals("")) {
            edittxt_fname.setError("This field can not be blank.");
            edittxt_fname.requestFocus();
            return false;
        }

        if (edittxt_lname.getText().toString().trim().equals("")) {
            edittxt_lname.setError("This field can not be blank.");
            edittxt_lname.requestFocus();
            return false;
        }
        
        if (edittxt_email.getText().toString().trim().equals("")) {
            edittxt_email.setError("This field can not be blank.");
            edittxt_email.requestFocus();
            return false;
        }

        if (!StaticUtil.isValidEmail(edittxt_email.getText().toString())) {
            edittxt_email.setError("Enter a valid email.");
            edittxt_email.requestFocus();
            return false;
        }


        if (edittxt_username.getText().toString().trim().equals("")) {
            edittxt_username.setError("This field can not be blank.");
            edittxt_username.requestFocus();
            return false;
        }

        if (edittxt_password.getText().toString().trim().equals("")) {
            edittxt_password.setError("This field can not be blank.");
            edittxt_password.requestFocus();
            return false;
        }

        if (edittxt_password.getText().toString().trim().length()<6){
            edittxt_password.setError("please enter atleast 6 digit password");
            edittxt_password.requestFocus();
            return false;
        }

        if (edittxt_confirmpassword.getText().toString().trim().equals("")) {
            edittxt_confirmpassword.setError("This field can not be blank.");
            edittxt_confirmpassword.requestFocus();
            return false;
        }

        if (edittxt_confirmpassword.getText().toString().trim().length()<6){
            edittxt_confirmpassword.setError("please enter atleast 6 digit password");
            edittxt_confirmpassword.requestFocus();
            return false;
        }

        if(edittxt_password.getText().toString().trim()!=(edittxt_confirmpassword.getText().toString().trim())){

            edittxt_confirmpassword.setError("please enter atleast 6 digit password");
            edittxt_confirmpassword.requestFocus();
            return false;

        }

       /* if (etMobile.getText().toString().trim().equals("")) {
            etMobile.setError("This field can not be blank.");
            etMobile.requestFocus();
            return false;
        }

        if (etMobile.getText().toString().trim().length()<10){
            etMobile.setError("please enter atleast 10 digit mobile no");
            etMobile.requestFocus();
            return false;
        }*/

        return true;
    }

    private void doSignUpApiCall() {

        Call<ResponseBody> responseBody = RestManager.getInstance().getService()
                .signUp(edittxt_fname.getText().toString(),edittxt_lname.getText().toString() ,edittxt_email.getText().toString(),edittxt_password.getText().toString(),edittxt_username.getText().toString(),"artist");
        responseBody.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                progressBar.setVisibility(View.GONE);
                try {
                    if (response.isSuccessful()) {
                        String val = response.body().string();
                        JSONObject jsonObject = new JSONObject(val);

                        String status = jsonObject.getString("status");

                        if (jsonObject.getString("status").equalsIgnoreCase("0")){

                            StaticUtil.showToast(RegisterActivity.this, jsonObject.getString("message"));
                            Intent intent =new Intent(getApplicationContext(),LoginActivity.class);
                            startActivity(intent);
                        }

                     /* else  if (jsonObject.getString("status").equalsIgnoreCase("1")) {

                            String user_type = jsonObject.getString("user_type");
                            JSONObject jsonObject1 = jsonObject.getJSONObject("data");

                            String FName = jsonObject1.getString("first_name");
                            String LName = jsonObject1.getString("last_name");

                            String userID = jsonObject1.getString("id");
                            String diaplayName = jsonObject1.getString("display_name");
                            String modelType = jsonObject1.getString("model_type");
                            String language = jsonObject1.getString("language");

                            session.createUserLoginSession(jsonObject1.getString("id"));
                            StaticUtil.showToast(RegisterActivity.this,jsonObject1.getString("id"));
                            Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                        }*/

                       else {

                        StaticUtil.showToast(RegisterActivity.this,"Nothing is there");
                    }

                    }



                }

                catch (IOException e) {
                    e.printStackTrace();
                }

                catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                progressBar.setVisibility(View.GONE);

            }
        });
    }
}