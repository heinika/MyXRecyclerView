package com.example.chenlijin.myxrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chenlijin.myxrecyclerview.R;
import com.example.chenlijin.myxrecyclerview.bean.BaseInfo;

import java.util.List;

/**
 * Created by chenlijin on 2016/3/13.
 */
public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {
    private List<BaseInfo> mBaseInfoList;
    private Context mContext;

    public TestAdapter(List<BaseInfo> mBaseInfoList, Context mContext) {
        this.mBaseInfoList = mBaseInfoList;
        this.mContext = mContext;
    }

    public void setbaseInfoList(List<BaseInfo> baseInfoList) {
        this.mBaseInfoList = baseInfoList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item,null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return mBaseInfoList == null?0:mBaseInfoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
