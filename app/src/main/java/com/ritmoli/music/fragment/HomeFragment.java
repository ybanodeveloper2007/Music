package com.ritmoli.music.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.facebook.CallbackManager;
import com.ritmoli.music.R;
import com.ritmoli.music.adapter.ArtistAdapter;
import com.ritmoli.music.adapter.GenresAdapter;
import com.ritmoli.music.adapter.GenresAdapter1;
import com.ritmoli.music.adapter.NewReleasesAdapter;
import com.ritmoli.music.adapter.PopularAlbumsAdapter;
import com.ritmoli.music.adapter.PopularTracksAdapter;
import com.ritmoli.music.model.ArtistResponse_Artist;
import com.ritmoli.music.model.CategoryInformation;
import com.ritmoli.music.model.Datum;
import com.ritmoli.music.networkservice.ApiClient;
import com.ritmoli.music.networkservice.ApiInterface;
import com.ritmoli.music.response.ArtistResponse;
import com.ritmoli.music.response.DiscoverResponse;


public class HomeFragment extends Fragment {

    CallbackManager callbackManager;
    private ApiInterface apiInterface;
    RecyclerView artistRecyclerView, genresRecyclerView, popularTrackRecyclerView,
            newReleasesRecyclerView, popularAlbumsRecylerView;
    List<ArtistResponse_Artist> artists;
    List<Datum> genres;
    List<CategoryInformation> genres1, popularTracks, newReleases, popularAlbums;
    ArtistAdapter artistsAdapter;
    GenresAdapter genresAdapter;
    PopularTracksAdapter popularTracksAdapter;
    GenresAdapter1 genresAdapter1;
    NewReleasesAdapter newReleasesAdapter;
    PopularAlbumsAdapter popularAlbumsAdapter;
    private ViewStub EmptyStateLayout, genresViewStub, newReleasesViewStub, recentlyPlayedViewStub, popularViewStub, artistsViewStub;
    private View Inflated, genresInflated, newReleasesInflated, recentlyPlayedInflated,
            popularInflated, artistsInflated;
    TextView textTitle;
    TextView genresTitle, artistTitle, recentlyPlayedTitle, newReleasesTitle, popularAlbumsTitle;
    Call<DiscoverResponse> callDiscover;
    Call<ArtistResponse> call;


    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.discover_layout, container, false);
        inflateViewStub(view);
        initialiseRecyclerView();
        initialiseTitleForRecyclerView();
        setLayoutMangerForRecyclerView();
        initialiseAdapter();
        attachAdapterToRecyclerView();
        startApiService();
        getApiResponse();
        return view;
    }


    private void inflateViewStub(View view) {
        genresInflated = ((ViewStub) view.findViewById(R.id.viewstub_browse)).inflate();
        artistsInflated = ((ViewStub) view.findViewById(R.id.viewstub_artists)).inflate();
        recentlyPlayedInflated = ((ViewStub) view.findViewById(R.id.viewStubRecentlyPlayed)).inflate();
        newReleasesInflated = ((ViewStub) view.findViewById(R.id.viewstub_newreleases)).inflate();
        popularInflated = ((ViewStub) view.findViewById(R.id.viewStubPopular)).inflate();
    }

    private void initialiseRecyclerView() {
        genresRecyclerView = genresInflated.findViewById(R.id.recyler);
        artistRecyclerView = artistsInflated.findViewById(R.id.recyler);
        popularTrackRecyclerView = popularInflated.findViewById(R.id.recyler);
        newReleasesRecyclerView = newReleasesInflated.findViewById(R.id.recyler);
        popularAlbumsRecylerView = popularInflated.findViewById(R.id.recyler);
    }

    private void initialiseTitleForRecyclerView() {
        genresTitle = genresInflated.findViewById(R.id.textTitle);
        artistTitle = artistsInflated.findViewById(R.id.textTitle);
        recentlyPlayedTitle = recentlyPlayedInflated.findViewById(R.id.textTitle);
        newReleasesTitle = newReleasesInflated.findViewById(R.id.textTitle);
        popularAlbumsTitle = popularInflated.findViewById(R.id.textTitle);
    }

    private void setLayoutMangerForRecyclerView() {
        artistRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        genresRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        popularTrackRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        newReleasesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        popularAlbumsRecylerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));

    }

    private void initialiseAdapter() {

        artistsAdapter = new ArtistAdapter(getActivity(), artists);
        genresAdapter = new GenresAdapter(getActivity(), genres);
        genresAdapter1 = new GenresAdapter1(getActivity(), genres1);
        popularTracksAdapter = new PopularTracksAdapter(getActivity(), genres1);
        newReleasesAdapter = new NewReleasesAdapter(getActivity(), newReleases);
        popularAlbumsAdapter = new PopularAlbumsAdapter(getActivity(), popularAlbums);

    }

    private void attachAdapterToRecyclerView() {
        artistRecyclerView.setAdapter(artistsAdapter);
        genresRecyclerView.setAdapter(genresAdapter1);
        popularTrackRecyclerView.setAdapter(popularTracksAdapter);
        newReleasesRecyclerView.setAdapter(newReleasesAdapter);
        popularAlbumsRecylerView.setAdapter(popularAlbumsAdapter);
    }

    private void startApiService() {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        callDiscover = apiInterface.getDiscover();
        call = apiInterface.getArtist("spotify_popularity");
    }

    private void getApiResponse() {

       getCallDiscoverApiResonse();
      //  getArtistApiResponse();
    }

    private void getCallDiscoverApiResonse() {
        callDiscover.enqueue(new Callback<DiscoverResponse>() {
            @Override
            public void onResponse(Call<DiscoverResponse> call, Response<DiscoverResponse> response) {
                if (response.body().getStatus().equalsIgnoreCase("1")) {

                    response.body().getChannel();
                    setDataForGenres(response);
                    setDataForPopularTracks(response);
                    setDataForNewRelease(response);
                    setDataForpopularAlbums(response);
                }
            }

            @Override
            public void onFailure(Call<DiscoverResponse> call, Throwable t) {

            }
        });
    }

    private void getArtistApiResponse() {
        call.enqueue(new Callback<ArtistResponse>() {
            @Override
            public void onResponse(Call<ArtistResponse> call, Response<ArtistResponse> response) {
               // setDataForArtists(response);
            }

            @Override
            public void onFailure(Call<ArtistResponse> call, Throwable t) {

            }
        });

    }

   /* private void setDataForArtists(Response<ArtistResponse> response) {
        artists = response.body().getArtistResponsePagination().getData();
        artistsAdapter.setArrayList(artists);
        artistsAdapter.notifyDataSetChanged();
        artistTitle.setText("Artists");
    }*/

    private void setDataForGenres(Response<DiscoverResponse> response) {
        genres1 = response.body().getChannel().getContent().get(3).getContent();
        genresTitle.setText(response.body().getChannel().getContent().get(3).getName());
        genresAdapter1.setArrayList(genres1);
        genresAdapter1.notifyDataSetChanged();
    }

    private void setDataForPopularTracks(Response<DiscoverResponse> response) {
        popularTracks = response.body().getChannel().getContent().get(1).getContent();
        // popTitle.setText(response.body().getChannel().getName());
        popularTracksAdapter.setArrayList(popularTracks);
        popularTracksAdapter.notifyDataSetChanged();
    }

    private void setDataForNewRelease(Response<DiscoverResponse> response) {
        newReleases = response.body().getChannel().getContent().get(2).getContent();
        newReleasesTitle.setText(response.body().getChannel().getContent().get(2).getName());
        newReleasesAdapter.setArrayList(newReleases);
        newReleasesAdapter.notifyDataSetChanged();
    }

    private void setDataForpopularAlbums(Response<DiscoverResponse> response) {
        popularAlbums = response.body().getChannel().getContent().get(0).getContent();
        popularAlbumsTitle.setText(response.body().getChannel().getContent().get(0).getName());
        popularAlbumsAdapter.setArrayList(popularAlbums);
        popularAlbumsAdapter.notifyDataSetChanged();
    }
}