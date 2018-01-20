package com.pg_community_android.functionalities.home;

import android.content.Context;
import android.support.annotation.NonNull;

import com.pg_community_android.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class PgMenuAdapter extends MenuAdapter {

    private PgMenuAdapterCallBack mPgMenuAdapterCallBack;
    private LinkedHashMap<Integer, Integer> menuItems = new LinkedHashMap<>();
    private List<Integer> menuLogos = new ArrayList<>();
    private HomeContract.MenuAdapterCallBack menuAdapterCallBack =
            new HomeContract.MenuAdapterCallBack() {
                @Override
                public void onItemClick(int menuId) {
                    switch (menuId) {
                        case R.string.title_profile:
                            mPgMenuAdapterCallBack.profile();
                            break;
                        case R.string.logout:
                            mPgMenuAdapterCallBack.logout();
                            break;
                        case R.string.jobs:
                            mPgMenuAdapterCallBack.jobs();
                            break;
                        case R.string.matrimony:
                            mPgMenuAdapterCallBack.matrimony();
                            break;
                    }
                }
            };

    public PgMenuAdapter(@NonNull Context context, @NonNull PgMenuAdapterCallBack pgMenuAdapterCallBack) {
        super(context);
        mPgMenuAdapterCallBack = pgMenuAdapterCallBack;
        menuItems.put(R.drawable.ic_person_black_24dp, R.string.title_profile);
        menuItems.put(R.drawable.ic_work_black_24dp, R.string.jobs);
        menuItems.put(R.drawable.ic_favorite_black_24dp, R.string.matrimony);
        menuItems.put(R.drawable.ic_lock_black_24px, R.string.logout);
        menuLogos.add(R.drawable.ic_person_black_24dp);
        menuLogos.add(R.drawable.ic_work_black_24dp);
        menuLogos.add(R.drawable.ic_favorite_black_24dp);
        menuLogos.add(R.drawable.ic_lock_black_24px);
        setMenuAdapterCallBack(menuAdapterCallBack);
        setLogoIds(menuLogos);
        setMenuItems(menuItems);

    }

    public interface PgMenuAdapterCallBack {
        void profile();

        void jobs();

        void matrimony();

        void logout();
    }

}
