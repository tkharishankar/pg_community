package com.pg_community_android.functionalities.profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pg_community_android.R;
import com.pg_community_android.functionalities.HomeActivity;
import com.pg_community_android.functionalities.PgMenuAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hari on 1/16/18.
 */

public class ProfileActivity extends HomeActivity implements ProfileView {

    @Inject
    ProfilePresenter<ProfileView> mPresenter;

    @BindView(R.id.name)
    EditText mNameEditText;

    @BindView(R.id.fatherName)
    EditText mFatherNameEditText;

    @BindView(R.id.motherName)
    EditText mMotherNameEditText;

    @BindView(R.id.phoneNumber)
    EditText mPhoneNumberEditText;

    @BindView(R.id.nativePlace)
    EditText mNativePlaceEditText;

    @BindView(R.id.nativeCity)
    EditText mNativeCityEditText;

    @BindView(R.id.currentCity)
    EditText mCurrentCityEditText;

    @BindView(R.id.currentState)
    EditText mCurrentStateEditText;

    @BindView(R.id.currentCountry)
    EditText mCurrentCountryEditText;

    @BindView(R.id.profile_layout)
    LinearLayout mProfilelayout;

    @BindView(R.id.drawer_layout)
    public DrawerLayout mDrawerLayout;

    private Menu mMenu;

    @BindView(R.id.menu_recycler)
    public RecyclerView mRecyclerDrawer;

    @BindView(R.id.titleTextView)
    public TextView mTxtVersion;

    @BindView(R.id.profileNameTextView)
    public TextView mTxtDriverName;

    @BindView(R.id.profileContactNumberTextView)
    public TextView profileContactNumberTextView;

    @BindView(R.id.mToolBar)
    public Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_home);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(ProfileActivity.this);

        setSupportActionBar(mToolbar);

        getSupportActionBar().setTitle(getResources().getString(R.string.title_profile));

        populateProfileInfo();

        disableView();

        enableView();

        initNavigationDrawer();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void populateProfileInfo() {
        mNameEditText.setText("Harishankar");
        mFatherNameEditText.setText("Kathirvel");
        mMotherNameEditText.setText("Jothimani");
        mPhoneNumberEditText.setText("+971554169711");
        mNativePlaceEditText.setText("Thudiyalur");
        mNativeCityEditText.setText("Coimbatore");
        mCurrentCityEditText.setText("Dubai");
        mCurrentStateEditText.setText("Dubai");
        mCurrentCountryEditText.setText("UAE");
    }

    @Override
    protected void setUp() {

    }

    private void disableView() {
        mNameEditText.setHintTextColor(getResources().getColor(R.color.colorAccent));
        mNameEditText.setTextColor(getResources().getColor(R.color.black));
        mFatherNameEditText.setHintTextColor(getResources().getColor(R.color.colorAccent));
        mFatherNameEditText.setTextColor(getResources().getColor(R.color.black));
        mMotherNameEditText.setHintTextColor(getResources().getColor(R.color.colorAccent));
        mMotherNameEditText.setTextColor(getResources().getColor(R.color.black));
        mPhoneNumberEditText.setHintTextColor(getResources().getColor(R.color.colorAccent));
        mPhoneNumberEditText.setTextColor(getResources().getColor(R.color.black));
        mNativePlaceEditText.setHintTextColor(getResources().getColor(R.color.colorAccent));
        mNativePlaceEditText.setTextColor(getResources().getColor(R.color.black));
        mNativeCityEditText.setHintTextColor(getResources().getColor(R.color.colorAccent));
        mNativeCityEditText.setTextColor(getResources().getColor(R.color.black));
        mCurrentCityEditText.setHintTextColor(getResources().getColor(R.color.colorAccent));
        mCurrentCityEditText.setTextColor(getResources().getColor(R.color.black));
        mCurrentStateEditText.setHintTextColor(getResources().getColor(R.color.colorAccent));
        mCurrentStateEditText.setTextColor(getResources().getColor(R.color.black));
        mCurrentCountryEditText.setHintTextColor(getResources().getColor(R.color.colorAccent));
        mCurrentCountryEditText.setTextColor(getResources().getColor(R.color.black));
        mNameEditText.setEnabled(false);
        mFatherNameEditText.setEnabled(false);
        mMotherNameEditText.setEnabled(false);
        mPhoneNumberEditText.setEnabled(false);
        mNativePlaceEditText.setEnabled(false);
        mNativeCityEditText.setEnabled(false);
        mCurrentCityEditText.setEnabled(false);
        mCurrentStateEditText.setEnabled(false);
        mCurrentCountryEditText.setEnabled(false);
    }

    private void enableView() {
        mNameEditText.setEnabled(true);
        mFatherNameEditText.setEnabled(true);
        mMotherNameEditText.setEnabled(true);
        mPhoneNumberEditText.setEnabled(true);
        mNativePlaceEditText.setEnabled(true);
        mNativeCityEditText.setEnabled(true);
        mCurrentCityEditText.setEnabled(true);
        mCurrentStateEditText.setEnabled(true);
        mCurrentCountryEditText.setEnabled(true);
    }

    @NonNull
    @Override
    protected RecyclerView providerRecyclerViewDrawer() {
        return mRecyclerDrawer;
    }

    @NonNull
    @Override
    protected TextView provideTextViewDriverName() {
        return mTxtDriverName;
    }

    @NonNull
    @Override
    protected TextView provideTextViewVersion() {
        return mTxtVersion;
    }

    @NonNull
    @Override
    protected TextView provideprofileContactNumberTextView() {
        return profileContactNumberTextView;
    }

    @NonNull
    @Override
    protected DrawerLayout provideDrawerLayout() {
        return mDrawerLayout;
    }

    @NonNull
    @Override
    protected Toolbar provideToolbar() {
        return mToolbar;
    }


    @NonNull
    @Override
    protected RecyclerView.Adapter provideMenuAdapter() {
        return new PgMenuAdapter(this, mMenuAdapterCallback);
    }

    private PgMenuAdapter.PgMenuAdapterCallBack mMenuAdapterCallback = new PgMenuAdapter.PgMenuAdapterCallBack() {
        @Override
        public void profile() {
            closeNavigationDrawer();
        }

        @Override
        public void matrimony() {
            //TODO : go to about screen
        }

        @Override
        public void logout() {

        }
    };
}
