package com.ritmoli.music.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ritmoli.music.R;
import com.ritmoli.retrofit.RestManager;
import com.ritmoli.utils.StaticUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EditProfileFragment extends Fragment {

    UserSessionManager session;
    EditText etName,edAbout,edFacebook,edWebsite;
    String id,email,name,apiToken;
    Button btnSubmit;

    public EditProfileFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static EditProfileFragment newInstance(String param1, String param2) {
        EditProfileFragment fragment = new EditProfileFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rView= inflater.inflate(R.layout.fragment_edit_profile, container, false);

        session = new UserSessionManager(getActivity());

        if(session.checkLogin())

            getActivity().finish();

        // get user data from session
        HashMap<String, String> user = session.getUserDetails();

        // get name
        name = user.get(UserSessionManager.KEY_NAME);

        // get email
        email = user.get(UserSessionManager.KEY_EMAIL);

       /*  apiToken = user.get(UserSessionManager.KEY_ID);*/
         id = user.get(UserSessionManager.KEY_ID);

        Toast.makeText(getActivity(), id, Toast.LENGTH_SHORT).show();

        etName=(EditText)rView.findViewById(R.id.FullNameEditText);
        edAbout=(EditText)rView.findViewById(R.id.AboutEditText);
        edFacebook=(EditText)rView.findViewById(R.id.FacebookEditText);
        edWebsite=(EditText)rView.findViewById(R.id.WebsiteEditText);
        btnSubmit=(Button)rView.findViewById(R.id.ApplyButton);

        getProfileApiCall();
       // etName.setText(name);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getProfileApiCall();
            }
        });

        return rView;
    }

    private void getProfileApiCall() {

        Call<ResponseBody> responseBody = RestManager.getInstance().getService()
                // .logIn(etEmail.getText().toString(), etPassword.getText().toString(), token);
                .getProfile(id);

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

                        if (status.equalsIgnoreCase("success")) {

                            StaticUtil.showToast(getActivity(), data);
                        }

                        else {
                            StaticUtil.showToast(getActivity(), data);
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

    private void getProfileEditApiCall() {

        Call<ResponseBody> responseBody = RestManager.getInstance().getService()
                // .logIn(etEmail.getText().toString(), etPassword.getText().toString(), token);
                .getProfile(id);

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

                        if (status.equalsIgnoreCase("success")) {

                            StaticUtil.showToast(getActivity(), data);
                        }

                        else {
                            StaticUtil.showToast(getActivity(), data);
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