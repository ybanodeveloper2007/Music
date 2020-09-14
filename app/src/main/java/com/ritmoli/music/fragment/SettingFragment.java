package com.ritmoli.music.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import com.ritmoli.music.R;
import com.ritmoli.music.activity.ChangePasswordActivity;
import com.ritmoli.music.activity.LoginActivity;
import com.ritmoli.music.activity.MainActivity;
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

public class SettingFragment extends Fragment  {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Fragment fragment = null;
    TextView tvMyAccount,tvEditProfile,tvPassword,tvPasswordValue,tvdeleteAccount,tvLogout;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    UserSessionManager session;
    String userId,email;


    public SettingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ActivityFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ActivityFragment newInstance(String param1, String param2) {
        ActivityFragment fragment = new ActivityFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rView= inflater.inflate(R.layout.settings_layout, container, false);

        // Session class instance
        session = new UserSessionManager(getActivity());
        if(session.checkLogin())

            getActivity().finish();

        // get user data from session
        HashMap<String, String> user = session.getUserDetails();


        // get email
        email = user.get(UserSessionManager.KEY_EMAIL);

        userId = user.get(UserSessionManager.KEY_ID);

        tvMyAccount=(TextView)rView.findViewById(R.id.tvMyAccount);
        tvEditProfile=(TextView)rView.findViewById(R.id.tvEditProfile);
        tvPassword=(TextView)rView.findViewById(R.id.tvPassword);
        tvPasswordValue=(TextView)rView.findViewById(R.id.tvPasswordValue);
        tvdeleteAccount=(TextView)rView.findViewById(R.id.tvDeleteAccount);
        tvLogout=(TextView)rView.findViewById(R.id.tvLogout);

        tvMyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadFragment(new ProfileInfoFragment());

            }
        });

        tvEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadFragment(new EditProfileFragment());
            }
        });

        tvPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadFragment(new ChangePasswordActivity());
            }
        });

        tvPasswordValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadFragment(new ChangePasswordActivity());
            }
        });

        tvdeleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // loadFragment(new ChangePasswordActivity());
                Toast.makeText(getActivity(), "Account deleted", Toast.LENGTH_SHORT).show();

            }
        });

        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               DoLogoutApiCall();
            }
        });

        return rView;
    }

    private void DoLogoutApiCall() {

        /*  RotateDialog.newInstance((Activity) getApplicationContext()).startLoading();*/

        Call<ResponseBody> responseBody = RestManager.getInstance().getService()
                // .logIn(etEmail.getText().toString(), etPassword.getText().toString(), token);
                .logOut("29");

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
                            Toast.makeText(getActivity(), "Logout Successfully", Toast.LENGTH_SHORT).show();
                            session.logoutUser();
                        }

                        else {

                            Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_SHORT).show();
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

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {

            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .commit();
            return true;
        }
        return false;
    }


}
