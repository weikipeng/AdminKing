package com.pengjunwei.android.mvp.recyclerview;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.pengjunwei.android.mvp.BasePresenter;
import com.pengjunwei.android.mvp.IViewParam;

import java.util.List;

/**
 * Created by WikiPeng on 2017/3/11 15:34.
 */
public class BaseRecyclerPresenter extends BasePresenter implements IRecyclerPresenter, IViewParamRecyclerView {
    protected BaseRecyclerAdapter mAdapter;

    protected int mRecyclerViewId;

    protected IViewParam mViewParam;

    public BaseRecyclerPresenter(Activity activity) {
        super(activity);
    }

    public BaseRecyclerPresenter(View view) {
        super(view);
    }

    public BaseRecyclerPresenter(View view, @IdRes int recyclerViewId) {
        super(view);
        mRecyclerViewId = recyclerViewId;
    }

    @Override
    public void setRecyclerViewData(List data) {
        mAdapter.clear();
        mAdapter.add(data);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void setAdapter(BaseRecyclerAdapter adapter) {
        mAdapter = adapter;
        ((IRecyclerView) mvpView).setAdapter(mAdapter);
    }

    protected void initViewParam() {
        mViewParam = this;
    }

    @Override
    public void onRecyclerViewItemClick(int position, RecyclerView.ViewHolder viewHolder, Object data) {

    }

    @Override
    public boolean onRecyclerViewItemLongClick(int position, RecyclerView.ViewHolder viewHolder, Object data) {
        return false;
    }

    @Override
    public boolean isRecyclerViewItemLongClickable(int position, RecyclerView.ViewHolder viewHolder, Object data) {
        return false;
    }
}
