package com.pg_community_android.functionalities.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.pg_community_android.R;
import com.pg_community_android.functionalities.home.HomeActivity;
import com.pg_community_android.functionalities.home.PgMenuAdapter;
import com.pg_community_android.functionalities.jobs.JobsActivity;
import com.pg_community_android.functionalities.matrimony.MatrimonyActivity;
import com.pg_community_android.functionalities.profile.ProfileActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hari on 1/16/18.
 */

public class WelcomeActivity extends HomeActivity {


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
        setContentView(R.layout.activity_welcome);

        setUnBinder(ButterKnife.bind(this));

        setSupportActionBar(mToolbar);

        getSupportActionBar().setTitle(getResources().getString(R.string.title_welcome));

        initNavigationDrawer();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    protected void setUp() {

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
            Intent intent = new Intent(WelcomeActivity.this, ProfileActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        }

        @Override
        public void jobs() {
            closeNavigationDrawer();
            Intent intent = new Intent(WelcomeActivity.this, JobsActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        }

        @Override
        public void matrimony() {
            //TODO : go to about screen

            closeNavigationDrawer();
            Intent intent = new Intent(WelcomeActivity.this, MatrimonyActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        }

        @Override
        public void logout() {

        }
    };
}
