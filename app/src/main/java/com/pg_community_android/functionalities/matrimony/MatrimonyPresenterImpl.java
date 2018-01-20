package com.pg_community_android.functionalities.matrimony;

import com.pg_community_android.base.BasePresenter;
import com.pg_community_android.data.DataManager;
import com.pg_community_android.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Hari on 1/20/18.
 */

public class MatrimonyPresenterImpl<V extends MatrimonyView> extends BasePresenter<V> implements MatrimonyPresenter<V> {
    @Inject
    public MatrimonyPresenterImpl(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
