package com.ritmoli.music.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ritmoli.music.R;
import com.ritmoli.retrofit.RestManager;
import com.ritmoli.utils.StaticUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgetPasswordActivity extends AppCompatActivity {

    EditText edittxt_email ;
    Button SignInButton;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password_layout);

        progressDialog=new ProgressDialog(this);

        edittxt_email=(EditText)findViewById(R.id.edt_email);

        SignInButton=(Button)findViewById(R.id.SignInButton);

        SignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edittxt_email.getText().toString().trim().equals("")) {
                    edittxt_email.setError("This field can not be blank.");
                    edittxt_email.requestFocus();}

                else {

                    progressDialog.setMessage("Loading...");
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    progressDialog.setCancelable(false);

                    getforgetPasswordApiCall();

                }
            }
        });
    }

    private void getforgetPasswordApiCall() {

        progressDialog.dismiss();

        Call<ResponseBody> responseBody = RestManager.getInstance().getService()
                // .logIn(etEmail.getText().toString(), etPassword.getText().toString(), token);
                .forgetPassword(edittxt_email.getText().toString());
        responseBody.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                //  RotateDialog.newInstance((Activity) getApplicationContext()).stopLoading();

                try {

                    if (response.isSuccessful()) {
                        String val = response.body().string();
                        JSONObject jsonObject = new JSONObject(val);

                        String status=jsonObject.getString("status");
                        String data=jsonObject.getString("data");

                        if (status.equalsIgnoreCase("1")) {

                            StaticUtil.showToast(ForgetPasswordActivity.this, data);
                        }

                        else {

                            StaticUtil.showToast(ForgetPasswordActivity.this, data);
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
            }
        });
    }
}