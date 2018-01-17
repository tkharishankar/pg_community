package com.pg_community_android.functionalities;

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
                        case R.string.home:
                            mPgMenuAdapterCallBack.home();
                            break;
                        case R.string.logout:
                            mPgMenuAdapterCallBack.logout();
                            break;
                        case R.string.about:
                            mPgMenuAdapterCallBack.about();
                            break;
                    }
                }
            };

    public PgMenuAdapter(@NonNull Context context, @NonNull PgMenuAdapterCallBack pgMenuAdapterCallBack) {
        super(context);
        mPgMenuAdapterCallBack = pgMenuAdapterCallBack;
        menuItems.put(R.drawable.ic_home_black_24px, R.string.home);
        menuItems.put(R.drawable.ic_info_black_24px, R.string.about);
        menuItems.put(R.drawable.ic_lock_black_24px, R.string.logout);
        menuLogos.add(R.drawable.ic_home_black_24px);
        menuLogos.add(R.drawable.ic_info_black_24px);
        menuLogos.add(R.drawable.ic_lock_black_24px);
        setMenuAdapterCallBack(menuAdapterCallBack);
        setLogoIds(menuLogos);
        setMenuItems(menuItems);

    }

    public interface PgMenuAdapterCallBack {
        void home();

        void about();

        void logout();
    }

}
