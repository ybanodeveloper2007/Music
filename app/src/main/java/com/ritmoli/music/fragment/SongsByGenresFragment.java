package com.ritmoli.music.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.ritmoli.music.R;
import com.ritmoli.music.adapter.SongsByGenresAdapter;

public class SongsByGenresFragment extends Fragment {


    RecyclerView songsByGeneresRecyclerView;
    SongsByGenresAdapter songsByGenresAdapter;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SongsByGenresFragment() {
        // Required empty public constructor
    }

    public static SongsByGenresFragment newInstance(String param1, String param2) {
        SongsByGenresFragment fragment = new SongsByGenresFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_default_layout, container, false);
        songsByGeneresRecyclerView = view.findViewById(R.id.recyler);
        songsByGenresAdapter = new SongsByGenresAdapter(getActivity(), mParam1);
        return view;
    }
}
