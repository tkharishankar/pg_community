package com.pg_community_android.functionalities.register;

import com.pg_community_android.R;
import com.pg_community_android.base.BasePresenter;
import com.pg_community_android.data.DataManager;
import com.pg_community_android.utils.CommonUtils;
import com.pg_community_android.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Hari on 1/15/18.
 */

public class RegisterPresenterImpl<V extends RegisterView> extends BasePresenter<V> implements RegisterPresenter<V> {

    @Inject
    public RegisterPresenterImpl(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onRegisterClick(String name, String surname, String email, String password, String confrimPassword) {
        //validate email and password
        if (name == null || name.isEmpty()) {
            getMvpView().onError(R.string.empty_name);
            return;
        }

        if (surname == null || surname.isEmpty()) {
            getMvpView().onError(R.string.empty_surname);
            return;
        }

        if (email == null || email.isEmpty()) {
            getMvpView().onError(R.string.empty_email);
            return;
        }

        if (!CommonUtils.isEmailValid(email)) {
            getMvpView().onError(R.string.invalid_email);
            return;
        }

        if (password == null || password.isEmpty()) {
            getMvpView().onError(R.string.empty_password);
            return;
        }

        if (confrimPassword == null || confrimPassword.isEmpty()) {
            getMvpView().onError(R.string.empty_confirm_password);
            return;
        }

        if (!password .equals(confrimPassword)) {
            getMvpView().onError(R.string.empty_password_mismatch);
            return;
        }

        getMvpView().showLoading();


    }
}
