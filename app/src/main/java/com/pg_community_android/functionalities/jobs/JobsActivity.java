package com.pg_community_android.functionalities.jobs;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.pg_community_android.R;
import com.pg_community_android.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hari on 1/20/18.
 */

public class JobsActivity extends BaseActivity implements JobsView {

    @Inject
    JobsPresenter<JobsView> mPresenter;

    @BindView(R.id.mToolBar)
    public Toolbar mToolbar;

    @Override
    protected void setUp() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(JobsActivity.this);

        setSupportActionBar(mToolbar);

        getSupportActionBar().setTitle(getResources().getString(R.string.title_matrimony));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }
}
