package com.pg_community_android.functionalities.register;

import com.pg_community_android.base.CommonPresenter;

/**
 * Created by Hari on 1/15/18.
 */

public interface RegisterPresenter<V extends RegisterView> extends CommonPresenter<V> {

    void onRegisterClick(String name, String surname, String email, String password, String confrimPassword);
}
