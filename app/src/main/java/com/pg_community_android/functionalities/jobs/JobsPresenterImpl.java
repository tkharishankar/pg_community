package com.pg_community_android.functionalities.jobs;

import com.pg_community_android.base.BasePresenter;
import com.pg_community_android.data.DataManager;
import com.pg_community_android.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Hari on 1/20/18.
 */

public class JobsPresenterImpl<V extends JobsView> extends BasePresenter<V> implements JobsPresenter<V> {
    @Inject
    public JobsPresenterImpl(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
