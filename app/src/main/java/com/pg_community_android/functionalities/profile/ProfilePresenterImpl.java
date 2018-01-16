package com.pg_community_android.functionalities.profile;

import com.pg_community_android.base.BasePresenter;
import com.pg_community_android.data.DataManager;
import com.pg_community_android.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Hari on 1/16/18.
 */

public class ProfilePresenterImpl<V extends ProfileView> extends BasePresenter<V> implements ProfilePresenter<V> {

    @Inject
    public ProfilePresenterImpl(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

}
