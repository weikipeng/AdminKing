package com.pengjunwei.android.mvp.recyclerview;

import android.support.v7.widget.RecyclerView;

import com.pengjunwei.android.mvp.IViewParam;

/**
 * Created by wikipeng on 2017/4/29.
 */

public interface IViewParamRecyclerView extends IViewParam {
    void onRecyclerViewItemClick(int position, RecyclerView.ViewHolder viewHolder, Object data);

    boolean onRecyclerViewItemLongClick(int position,RecyclerView.ViewHolder viewHolder, Object data);

    boolean isRecyclerViewItemLongClickable(int position,RecyclerView.ViewHolder viewHolder, Object data);
}
