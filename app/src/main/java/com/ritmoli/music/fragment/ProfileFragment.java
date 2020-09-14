package com.ritmoli.music.fragment;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.ritmoli.music.R;
import com.ritmoli.music.activity.ForgetPasswordActivity;
import com.ritmoli.music.activity.MainActivity;
import com.ritmoli.retrofit.RestManager;
import com.ritmoli.utils.CustomDialog;
import com.ritmoli.utils.StaticUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.ritmoli.music.activity.LoginActivity.ApiToken;
import static com.ritmoli.music.activity.LoginActivity.Email;
import static com.ritmoli.music.activity.LoginActivity.Name;
import static com.ritmoli.music.activity.LoginActivity.UserID;
import static com.ritmoli.music.activity.LoginActivity.avatar;


public class ProfileFragment extends Fragment implements View.OnClickListener {

    private MainActivity GlobalContext;
    private CollapsingToolbarLayout CollapsingToolbar;
    private com.google.android.material.appbar.AppBarLayout AppBarLayout;
    private ImageView IconPro, IconMore, IconInfo;
    public ImageView ImageCover;
    public CircleImageView ImageAvatar;
    private TextView TxtFullName ,TxtCountFollowers , TxtFollowers , TxtCountFollowing , TxtFollowing;
    private Button EditButton;
    private ViewPager ViewPagerView;
    private TabLayout Tabs;
    private FloatingActionButton BtnEdit;
    private RequestBuilder FullGlideRequestBuilder;
    private RequestOptions GlideRequestOptions;
    UserSessionManager session;
    String id,email,name,apiToken;

  /*  public UserActivitiesFragment ActivitiesFragment;
    public UserAlbumsFragment AlbumsFragment;
    public UserLikedFragment LikedFragment;
    public UserPlaylistFragment PlaylistFragment;
    public UserSongsFragment SongsFragment;
    public UserStationsFragment StationsFragment;
    public UserStoreFragment StoreFragment;
    public ContactsFragment ContactsFragment;*/

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.tprofilelayout, container, false);

        // Session class instance
        session = new UserSessionManager(getActivity());

        if(session.checkLogin())

            getActivity().finish();

        // get user data from session
        HashMap<String, String> user = session.getUserDetails();

        // get name
         name = user.get(UserSessionManager.KEY_NAME);

        // get email
       email = user.get(UserSessionManager.KEY_EMAIL);

       id = user.get(UserSessionManager.KEY_ID);

       apiToken = user.get(UserSessionManager.KEY_apiToken);

        Toast.makeText(getActivity(), id , Toast.LENGTH_SHORT).show();

        CollapsingToolbar = (CollapsingToolbarLayout)view.findViewById(R.id.collapsingToolbar);
      //  CollapsingToolbar.ti() = "";

        AppBarLayout = (AppBarLayout)view.findViewById(R.id.appBarLayout);
        AppBarLayout.setExpanded(true);
      //  AppBarLayout.addOnOffsetChangedListener(this);

        ImageCover = (ImageView)view.findViewById(R.id.imageCover);

        IconPro = (ImageView)view.findViewById(R.id.pro);
      //  IconPro.Visibility = ViewStates.Invisible;

        IconMore = (ImageView)view.findViewById(R.id.more);
      //  IconMore.Click += ButtonMoreOnClick;

        IconInfo = (ImageView)view.findViewById(R.id.info);

      //  IconInfo.Click += IconInfoOnClick;

        ImageAvatar = (CircleImageView)view.findViewById(R.id.imageAvatar);
       // ImageAvatar.Click += ImageAvatarOnClick;

        TxtFullName = (TextView)view.findViewById(R.id.fullNameTextView);

        TxtCountFollowers = (TextView)view.findViewById(R.id.countFollowersTextView);
        TxtFollowers = (TextView)view.findViewById(R.id.FollowersTextView);

       // TxtFollowers.Click += TxtFollowersOnClick;
      //  TxtCountFollowers.Click += TxtFollowersOnClick;

        TxtCountFollowing = (TextView)view.findViewById(R.id.countFollowingTextView);
        TxtFollowing = (TextView)view.findViewById(R.id.FollowingTextView);
      //  TxtFollowing.Click += TxtFollowingOnClick;
       // TxtCountFollowing.Click += TxtFollowingOnClick;

        EditButton = (Button)view.findViewById(R.id.EditButton);

      //  EditButton.Click += BtnEditOnClick;

        ViewPagerView = (ViewPager)view.findViewById(R.id.profileViewPager);
        addTabs(ViewPagerView);
        Tabs = (TabLayout)view.findViewById(R.id.sectionsTabs);
        Tabs.setupWithViewPager(ViewPagerView);
       // setupTabIcons();

        BtnEdit = (FloatingActionButton)view.findViewById(R.id.fab);
        BtnEdit.setOnClickListener(this);
        EditButton.setOnClickListener(this);
        IconInfo.setOnClickListener(this);
        IconMore.setOnClickListener(this);

     //   BtnEdit.Click += BtnEditOnClick;

      //  TxtFullName.setText(name);
       // Glide.with(getActivity()).load(avatar).into(ImageAvatar);

        getProfileApiCall();
       /// Glide.with(getActivity()).load(R.drawable.imageplacholder).into();

        return view;
    }

    private void getProfileApiCall() {
        Call<ResponseBody> responseBody = RestManager.getInstance().getService()
                // .logIn(etEmail.getText().toString(), etPassword.getText().toString(), token);
             //   .getProfile(id);
                .getProfile("96");
        responseBody.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                //  RotateDialog.newInstance((Activity) getApplicationContext()).stopLoading();

                try {

                    if (response.isSuccessful()) {
                        String val = response.body().string();
                        JSONObject jsonObject = new JSONObject(val);

                        String status=jsonObject.getString("status");
                        String data=jsonObject.getString("user_id");
                        String cover_image=jsonObject.getString("cover_image");
                        String following=jsonObject.getString("following");
                        String followers=jsonObject.getString("followers");

                      //  if (status.equalsIgnoreCase("1")) {

                            StaticUtil.showToast(getActivity(), data+following+followers+cover_image);
                      //  }

                    //   else {

                         //   StaticUtil.showToast(getActivity(), data);
                      //  }
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
                    .addToBackStack("ProfileFragment")
                    .commit();

            return true;
        }

        return false;
    }

    private void addTabs(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFrag(new ActivityFragment(), "ACTIVITIES");
        adapter.addFrag(new ActivityFragment(), "ALBUMS");
        adapter.addFrag(new ActivityFragment(), "LIKED");
        adapter.addFrag(new ActivityFragment(), "PLAYLIST");
        adapter.addFrag(new ActivityFragment(), "SONGS");
        viewPager.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.EditButton:
                loadFragment(new EditProfileFragment());
                 break;

            case R.id.fab:
                loadFragment(new EditProfileFragment());
                break;

            case R.id.more:

                showDialog("", "", getActivity(), "1");

                break;

            case R.id.info:

                loadFragment(new ProfileInfoFragment());
                break;
        }
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


    public void showDialog(String header, String message, final Context mcontext, String chek){
        final Dialog dialog = new Dialog(mcontext);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_dialogue);

        // Typeface typeface = Typeface.createFromAsset(am, String.format(Locale.US, "fonts/%s", "HindGuntur-Regular.ttf"));
        // Typeface tf = Typeface.createFromAsset(am, String.format(Locale.US, "fonts/%s", "HindGuntur-Light.ttf"));
        //  TextView customTextView = (TextView) dialog.findViewById(R.id.dialog_header);

        TextView  tvImageCover = (TextView) dialog.findViewById(R.id.label_popup_one);
        TextView  tvSetting = (TextView) dialog.findViewById(R.id.label_popup_two);
        TextView  tvInfo = (TextView) dialog.findViewById(R.id.label_popup_three);
        TextView  tvClose = (TextView) dialog.findViewById(R.id.label_close);

        if(chek.equalsIgnoreCase("1")){

            //dialog.show();
            tvImageCover.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dialog.dismiss();

                }
            });

            tvSetting.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dialog.dismiss();

                    loadFragment(new SettingFragment());

                }

            });

            tvInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dialog.dismiss();

                }
            });

            tvClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();

                }
            });
        }

        dialog.show();
    }

}