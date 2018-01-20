package com.pg_community_android.functionalities.jobs.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.pg_community_android.functionalities.jobs.JobsView;
import com.pg_community_android.model.Jobs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hari on 1/20/18.
 */

public class JobsAdapter extends RecyclerView.Adapter<JobsAdapter.ViewHolder> {

    private List<Jobs> mJobsList = new ArrayList<>();
    private JobsView.AdapterCallBack mAdapterCallBack;

    public JobsAdapter(JobsView.AdapterCallBack adapterCallBack, List<Jobs> mJobsList) {
        this.mJobsList = mJobsList;
        this.mAdapterCallBack=adapterCallBack;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
