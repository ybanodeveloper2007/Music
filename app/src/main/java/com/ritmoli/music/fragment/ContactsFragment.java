package com.ritmoli.music.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import com.ritmoli.music.R;
import com.ritmoli.music.activity.Player;
import com.ritmoli.music.adapter.ArtistAdapter;
import com.ritmoli.music.adapter.ContactsAdapter;
import com.ritmoli.music.model.Datum;
import com.ritmoli.music.model.Followers;
import com.ritmoli.music.networkservice.ApiClient;
import com.ritmoli.music.networkservice.ApiInterface;
import com.ritmoli.music.response.FollowersResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContactsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    List<Followers> followers;
    ContactsAdapter contactsAdapter;
    private ApiInterface apiInterface;
    public ContactsFragment() {
        // Required empty public constructor
    }

    public static ContactsFragment newInstance(String param1, String param2) {
        ContactsFragment fragment = new ContactsFragment();
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
       View view = inflater.inflate(R.layout.recycler_default_layout, container, false);
        TextView toolBartitle = view.findViewById(R.id.toolbar_title);
        toolBartitle.setText("Followers");
        toolBartitle.setVisibility(View.VISIBLE);
        RecyclerView contactsRecyclerView = view.findViewById(R.id.recyler);
        contactsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        final ContactsAdapter contactsAdapter = new ContactsAdapter(getActivity(),followers);
        contactsRecyclerView.setAdapter(contactsAdapter);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<FollowersResponse> callFollowers = apiInterface.getFollowers("1");
        callFollowers.enqueue(new Callback<FollowersResponse>() {
            @Override
            public void onResponse(Call<FollowersResponse> call, Response<FollowersResponse> response) {

                followers = response.body().getPagination().getData();
                contactsAdapter.setArrayList(followers);
                contactsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<FollowersResponse> call, Throwable t) {

            }
        });

        return view;
    }
}