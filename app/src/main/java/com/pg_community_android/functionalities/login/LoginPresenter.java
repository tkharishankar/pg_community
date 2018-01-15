
package com.pg_community_android.functionalities.login;

import com.pg_community_android.base.CommonPresenter;
import com.pg_community_android.di.PerActivity;

@PerActivity
public interface LoginPresenter<V extends LoginView> extends CommonPresenter<V> {

    void onServerLoginClick(String email, String password);

    void onGoogleLoginClick();

    void onFacebookLoginClick();

}
