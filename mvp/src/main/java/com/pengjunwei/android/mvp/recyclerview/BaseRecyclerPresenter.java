package com.pengjunwei.android.mvp.recyclerview;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.view.View;

import com.pengjunwei.android.mvp.BasePresenter;
import com.pengjunwei.android.mvp.IViewParam;

import java.util.List;

/**
 * Created by WikiPeng on 2017/3/11 15:34.
 */
public class BaseRecyclerPresenter extends BasePresenter implements IRecyclerPresenter {
    protected BaseRecyclerAdapter mAdapter;

    protected int mRecyclerViewId;

    protected IViewParam            mViewParam;
    protected ViewParamRecyclerView viewParamRecyclerView;

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
        viewParamRecyclerView = new ViewParamRecyclerView();
        viewParamRecyclerView.onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = ((IRecyclerView)mvpView).getPositionByView(v);
                onRecyclerViewItemClick(position);
            }
        };
        viewParamRecyclerView.onLongClickListener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = ((IRecyclerView)mvpView).getPositionByView(v);
                return onRecyclerViewItemLongClick(position);
            }
        };
        mViewParam = new IRecyclerViewParam() {
            @Override
            public ViewParamRecyclerView getViewParamRecyclerView() {
                return viewParamRecyclerView;
            }
        };
    }

    protected boolean onRecyclerViewItemLongClick(int position) {
        return false;
    }

    protected void onRecyclerViewItemClick(int position) {

    }

}
