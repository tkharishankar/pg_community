package com.pg_community_android.functionalities;

import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.pg_community_android.R;
import com.pg_community_android.base.BaseActivity;

/**
 * Created by Hari on 1/17/18.
 */

public abstract class HomeActivity extends BaseActivity {

    private ActionBarDrawerToggle mToggle;

    /**
     * this method have to be call after the toolbar initialisation
     */
    protected void initNavigationDrawer() {
        mToggle = new ActionBarDrawerToggle(this, provideDrawerLayout(), provideToolbar(), R.string.app_name, R.string.app_name) {

            public void onDrawerClosed(View view) {
            }

            public void onDrawerOpened(View view) {
            }
        };
        provideDrawerLayout().addDrawerListener(mToggle);
        mToggle.syncState();
        provideToolbar().setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (provideDrawerLayout().isDrawerOpen(Gravity.LEFT)) {
                    closeNavigationDrawer();
                } else {
                    openNavigationDrawer();
                }
            }
        });
        provideprofileContactNumberTextView().setText("Harishankar Kathirvel");
        providerRecyclerViewDrawer().setLayoutManager(new GridLayoutManager(this, 1));
        providerRecyclerViewDrawer().setAdapter(provideMenuAdapter());
    }

    protected boolean isNavigationDrawerOpen() {
        return provideDrawerLayout().isDrawerOpen(Gravity.LEFT);
    }

    @Override
    public void onBackPressed() {
        if (isNavigationDrawerOpen()) {
            closeNavigationDrawer();
        } else {
            super.onBackPressed();
        }
    }

    protected void closeNavigationDrawer() {
        provideDrawerLayout().closeDrawer(Gravity.LEFT);
    }

    protected void openNavigationDrawer() {
        provideDrawerLayout().openDrawer(Gravity.LEFT);
    }

    protected abstract @NonNull
    RecyclerView providerRecyclerViewDrawer();

    protected abstract @NonNull
    TextView provideTextViewDriverName();

    protected abstract @NonNull
    TextView provideTextViewVersion();

    @NonNull
    protected abstract TextView provideprofileContactNumberTextView();

    protected abstract @NonNull
    DrawerLayout provideDrawerLayout();

    protected abstract @NonNull
    Toolbar provideToolbar();

    protected abstract @NonNull
    RecyclerView.Adapter provideMenuAdapter();
}

