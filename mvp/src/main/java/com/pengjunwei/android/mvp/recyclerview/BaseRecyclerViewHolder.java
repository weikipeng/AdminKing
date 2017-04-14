package com.pengjunwei.android.mvp.recyclerview;

import android.support.annotation.CallSuper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.pengjunwei.android.mvp.IViewParam;

/**
 * Created by WikiPeng on 2017/3/11 15:59.
 */
public abstract class BaseRecyclerViewHolder extends RecyclerView.ViewHolder {
    protected Object     mData;
    protected IViewParam mViewParam;

    public BaseRecyclerViewHolder(View itemView, IViewParam viewParam) {
        super(itemView);
        this.mViewParam = viewParam;
    }

    protected void addEvent() {
        if (mViewParam instanceof IRecyclerViewParam) {
            ViewParamRecyclerView viewParamRecyclerView = ((IRecyclerViewParam) mViewParam).getViewParamRecyclerView();
            if (viewParamRecyclerView != null) {
                itemView.setOnClickListener(viewParamRecyclerView.onClickListener);
                itemView.setOnLongClickListener(viewParamRecyclerView.onLongClickListener);
            }
        }
    }


    @CallSuper
    public void onBindViewHolder(int position, Object data) {
        this.mData = data;
    }
}
