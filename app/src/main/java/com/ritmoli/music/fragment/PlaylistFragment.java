package com.ritmoli.music.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ritmoli.music.R;
import com.ritmoli.music.adapter.PublicPlaylistAdapter;
import com.ritmoli.music.model.PublicPlayList;
import com.ritmoli.music.networkservice.ApiClient;
import com.ritmoli.music.networkservice.ApiInterface;
import com.ritmoli.music.response.PublicPlaylistResponse;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlaylistFragment#newInstance} factory method to
 * create an instance of this fragment.
 */


public class PlaylistFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    List<PublicPlayList> publicPlayLists;

    public PlaylistFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlaylistFragment.
     */
    // TODO: Rename and change types and number of parameters

    public static PlaylistFragment newInstance(String param1, String param2) {
        PlaylistFragment fragment = new PlaylistFragment();
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
        View  view = inflater.inflate(R.layout.tplaylist_layout, container, false);
        FloatingActionButton floatingAdd = view.findViewById(R.id.floatingAdd);
        View publicPlaylistInflated = ((ViewStub) view.findViewById(R.id.viewStubPublicePlaylist)).inflate();
        RecyclerView publicRecyclerView = publicPlaylistInflated.findViewById(R.id.recyler);
        final TextView publicPlaylistTitle = publicPlaylistInflated.findViewById(R.id.textTitle);
        publicRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        final PublicPlaylistAdapter publicPlaylistAdapter = new PublicPlaylistAdapter(getActivity(), publicPlayLists);
        publicRecyclerView.setAdapter(publicPlaylistAdapter);
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<PublicPlaylistResponse> callPublicPlayListResponse = apiInterface.getPublicPlaylist("1");
        callPublicPlayListResponse.enqueue(new Callback<PublicPlaylistResponse>() {
            @Override
            public void onResponse(Call<PublicPlaylistResponse> call, Response<PublicPlaylistResponse> response) {
                publicPlayLists = response.body().getPagination().getData();
                publicPlaylistTitle.setText("HotplayList");
                publicPlaylistAdapter.setArrayList(publicPlayLists);
                publicPlaylistAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<PublicPlaylistResponse> call, Throwable t) {
                Log.d("Sri",""+t);
            }
        });

        floatingAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the fragment and show it as a dialog.
               /* CreatePlayListFragment newFragment = CreatePlayListFragment.newInstance(null,null);
                newFragment.show(getFragmentManager(),"dialog");*/

            }
        });

        return view;
    }


}