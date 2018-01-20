package com.pg_community_android.functionalities.register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.pg_community_android.R;
import com.pg_community_android.base.BaseActivity;
import com.pg_community_android.functionalities.welcome.WelcomeActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Hari on 12/5/17.
 */

public class RegisterActivity extends BaseActivity implements RegisterView{

    @Inject
    RegisterPresenter<RegisterView> mPresenter;

    @BindView(R.id.name)
    EditText mNameEditText;

    @BindView(R.id.surname)
    EditText mSurnameEditText;

    @BindView(R.id.email)
    EditText mEmailEditText;

    @BindView(R.id.password)
    EditText mPasswordEditText;

    @BindView(R.id.confrim_password)
    EditText mConfirmPasswordEditText;

    @BindView(R.id.mToolBar)
    public Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(RegisterActivity.this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.title_register));
        hideKeyboard();

    }


    @OnClick(R.id.register_button)
    void onRegisterButtonClick(View v) {
        mPresenter.onRegisterClick(mNameEditText.getText().toString().trim(),
                mSurnameEditText.getText().toString().trim(),
                mEmailEditText.getText().toString().trim(),
                mPasswordEditText.getText().toString().trim(),
                mConfirmPasswordEditText.getText().toString().trim());

        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }

    @Override
    protected void setUp() {

    }


}
