
package com.pg_community_android.functionalities.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.pg_community_android.R;
import com.pg_community_android.base.BaseActivity;
import com.pg_community_android.functionalities.register.RegisterActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends BaseActivity implements LoginView {

    @Inject
    LoginPresenter<LoginView> mPresenter;

    @BindView(R.id.email)
    EditText mEmailEditText;

    @BindView(R.id.password)
    EditText mPasswordEditText;

    @BindView(R.id.mToolBar)
    public Toolbar mToolbar;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(LoginActivity.this);

        setSupportActionBar(mToolbar);

        getSupportActionBar().setTitle(getResources().getString(R.string.title_login));
    }

    @OnClick(R.id.sign_in_button)
    void onServerLoginClick(View v) {
        mPresenter.onServerLoginClick(mEmailEditText.getText().toString(),
                mPasswordEditText.getText().toString());
        Intent intent = LoginActivity.getStartIntent(LoginActivity.this);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.sign_up_button)
    void onSignupClick(View v) {
        hideKeyboard();
        Intent intent = LoginActivity.getStartIntent(LoginActivity.this);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

    }

    @OnClick(R.id.forgot_button)
    void onForgotpasswordClick(View v) {
        mPresenter.onServerLoginClick(mEmailEditText.getText().toString(),
                mPasswordEditText.getText().toString());
    }

    @Override
    public void openMainActivity() {
        Intent intent = LoginActivity.getStartIntent(LoginActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
    }

}
