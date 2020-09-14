package com.ritmoli.music.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class ChangePasswordActivity extends Fragment {

    EditText  tvcurrentPasswordText,newPsswordText,repeatPasswordText;
    TextView linkText,tvsave;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rView= inflater.inflate(R.layout.activity_change_password, container, false);

        tvcurrentPasswordText=(EditText)rView.findViewById(R.id.currentPasswordText);
        newPsswordText=(EditText)rView.findViewById(R.id.newPsswordText);
        repeatPasswordText=(EditText)rView.findViewById(R.id.repeatPasswordText);
        linkText=(TextView) rView.findViewById(R.id.linkText);
        tvsave=(TextView) rView.findViewById(R.id.toolbar_title);

        tvsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doPasswordwok();
            }

        });

        return rView;

    }

    private void doPasswordwok() {

        /*  RotateDialog.newInstance((Activity) getApplicationContext()).startLoading();*/

        Call<ResponseBody> responseBody = RestManager.getInstance().getService()
                // .logIn(etEmail.getText().toString(), etPassword.getText().toString(), token);
                .PasswordChange("29",tvcurrentPasswordText.getText().toString() , newPsswordText.getText().toString(),repeatPasswordText.getText().toString());
        responseBody.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                //  RotateDialog.newInstance((Activity) getApplicationContext()).stopLoading();

                try {

                    if (response.isSuccessful()) {
                        String val = response.body().string();
                        JSONObject jsonObject = new JSONObject(val);

                        String status=jsonObject.getString("status");
                        String message=jsonObject.getString("message");

                        //    JSONObject nestedJsonObjectVal = jsonObject.getJSONObject("user");

                        if (status.equalsIgnoreCase("1")) {

                         /*   session.createUserLoginSession(nestedJsonObjectVal.optString("first_name").toString(),
                                    nestedJsonObjectVal.optString("email"),nestedJsonObjectVal.optString("id").toString(),nestedJsonObjectVal.optString("api_token"),nestedJsonObjectVal.optString("avatar"));
*/
                            StaticUtil.showToast(getActivity(), message);

                           /* Intent intent =new Intent(getActivity(),MainActivity.class);
                            startActivity(intent);*/
                        }

                        else {

                            StaticUtil.showToast(getActivity(), message);
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