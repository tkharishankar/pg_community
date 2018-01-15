
package com.pg_community_android.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.pg_community_android.di.ActivityContext;
import com.pg_community_android.di.PerActivity;
import com.pg_community_android.functionalities.login.LoginPresenter;
import com.pg_community_android.functionalities.login.LoginPresenterImpl;
import com.pg_community_android.functionalities.login.LoginView;
import com.pg_community_android.functionalities.register.RegisterPresenter;
import com.pg_community_android.functionalities.register.RegisterPresenterImpl;
import com.pg_community_android.functionalities.register.RegisterView;
import com.pg_community_android.utils.rx.AppSchedulerProvider;
import com.pg_community_android.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }


    @Provides
    @PerActivity
    LoginPresenter<LoginView> provideLoginPresenter(
            LoginPresenterImpl<LoginView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    RegisterPresenter<RegisterView> provideRegisterPresenter(
            RegisterPresenterImpl<RegisterView> presenter) {
        return presenter;
    }


}
