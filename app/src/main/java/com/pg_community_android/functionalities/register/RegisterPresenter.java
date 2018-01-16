package com.pg_community_android.functionalities.register;

import com.pg_community_android.base.CommonPresenter;
import com.pg_community_android.di.PerActivity;

/**
 * Created by Hari on 1/15/18.
 */
@PerActivity
public interface RegisterPresenter<V extends RegisterView> extends CommonPresenter<V> {

    void onRegisterClick(String name, String surname, String email, String password, String confrimPassword);
}
