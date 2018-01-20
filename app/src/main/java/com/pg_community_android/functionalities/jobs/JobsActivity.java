package com.pg_community_android.functionalities.jobs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.pg_community_android.R;
import com.pg_community_android.base.BaseActivity;
import com.pg_community_android.functionalities.jobs.adapter.JobsAdapter;
import com.pg_community_android.model.Jobs;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hari on 1/20/18.
 */

public class JobsActivity extends BaseActivity implements JobsView, JobsView.AdapterCallBack {

    @Inject
    JobsPresenter<JobsView> mPresenter;

    @BindView(R.id.mToolBar)
    public Toolbar mToolbar;

    @BindView(R.id.orderlist)
    RecyclerView mRecyclerView;

    JobsAdapter mAdapter;

    RecyclerView.LayoutManager mLayoutManager;

    List<Jobs> mJobsList = new ArrayList<>();

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

        getSupportActionBar().setTitle(getResources().getString(R.string.title_jobs));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setAdapter();

    }

    private void setAdapter() {
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this, 1);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new JobsAdapter(this, mJobsList);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {

        int id = menuItem.getItemId();

        if (id == R.id.action_add) {
            Intent intent = new Intent(JobsActivity.this, AddNewJobActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        } else if (menuItem.getItemId() == android.R.id.home) {
            finish();
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        }

        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.jobs, menu);
        return true;
    }
}
