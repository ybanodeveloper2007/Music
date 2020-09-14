package com.ritmoli.music.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ritmoli.music.R;


public class LibraryFragment extends Fragment {

    public LibraryFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static LibraryFragment newInstance(String param1, String param2) {
        LibraryFragment fragment = new LibraryFragment();
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
        View RView= inflater.inflate(R.layout.tlibrary_layout, container, false);

        return RView ;
    }
}