package com.pg_community_android.functionalities.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pg_community_android.R;

import java.util.HashMap;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private HashMap<Integer, Integer> mMenuItems;
    private List<Integer> mLogoIds;
    private Context mContext;

    public void setMenuItems(HashMap<Integer, Integer> mMenuItems) {
        this.mMenuItems = mMenuItems;
    }

    public void setLogoIds(List<Integer> mLogoIds) {
        this.mLogoIds = mLogoIds;
    }

    public void setMenuAdapterCallBack(HomeContract.MenuAdapterCallBack mMenuAdapterCallBack) {
        this.mMenuAdapterCallBack = mMenuAdapterCallBack;
    }

    private HomeContract.MenuAdapterCallBack mMenuAdapterCallBack;

    public MenuAdapter(Context context) {
        mContext = context;
    }

    public MenuAdapter(Context context, HashMap<Integer, Integer> menuItems, List<Integer> logoIds, HomeContract.MenuAdapterCallBack menuAdapterCallBack) {
        mMenuItems = menuItems;
        mLogoIds = logoIds;
        mContext = context;
        mMenuAdapterCallBack = menuAdapterCallBack;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_dashboard_menu, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public int getItemCount() {
        return mLogoIds.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mMenuText.setText(mContext.getString(mMenuItems.get(mLogoIds.get(position))));
        holder.iconView.setImageResource(mLogoIds.get(position));
        holder.menuLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMenuAdapterCallBack.onItemClick(mMenuItems.get(mLogoIds.get(position)));
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mMenuText;
        public ImageView iconView;
        private RelativeLayout menuLayout;

        public ViewHolder(View v) {
            super(v);

            mMenuText = (TextView) v.findViewById(R.id.txt_so_no);
            iconView = (ImageView) v.findViewById(R.id.list_menu_logo);
            menuLayout = (RelativeLayout) v.findViewById(R.id.menu_layout);

        }
    }

}
