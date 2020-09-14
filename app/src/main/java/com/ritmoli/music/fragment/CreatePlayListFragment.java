package com.ritmoli.music.fragment;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.ritmoli.music.R;
import com.ritmoli.music.networkservice.ApiClient;
import com.ritmoli.music.networkservice.ApiInterface;
import com.ritmoli.music.request.CreatePlaylist;
import com.ritmoli.music.response.CreatePlaylistResponse;
import com.ritmoli.music.response.FollowersResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreatePlayListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreatePlayListFragment extends DialogFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CreatePlayListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreatePlayListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreatePlayListFragment newInstance(String param1, String param2) {
        CreatePlayListFragment fragment = new CreatePlayListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_FRAME, android.R.style.Theme_Holo_Light);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.create_playlist_layout, container, false);
        EditText NameEditText = view.findViewById(R.id.NameEditText);
        RadioGroup radioPrivacy = view.findViewById(R.id.radioPrivacy);
        Button crateBtn = view.findViewById(R.id.ApplyButton);
        CreatePlaylist createPlaylist = new CreatePlaylist();
        createPlaylist.setName(NameEditText.getText().toString());
        createPlaylist.setDescription("Test Descri");
        createPlaylist.setImage(String.valueOf(R.drawable.loginimage));
       ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        final Call<CreatePlaylistResponse> callCreatePlaylist = apiInterface.createPlaylist(createPlaylist);
        crateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callCreatePlaylist.enqueue(new Callback<CreatePlaylistResponse>() {
                    @Override
                    public void onResponse(Call<CreatePlaylistResponse> call, Response<CreatePlaylistResponse> response) {
                        Log.d("Sri",""+response);
                    }

                    @Override
                    public void onFailure(Call<CreatePlaylistResponse> call, Throwable t) {
                        Log.d("Sri",""+t);
                    }
                });
            }
        });
        return view;
    }
}