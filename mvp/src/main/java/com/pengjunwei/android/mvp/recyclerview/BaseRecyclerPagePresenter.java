package com.pengjunwei.android.mvp.recyclerview;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.view.View;

import com.pengjunwei.android.mvp.IViewParam;

/**
 * Created by WikiPeng on 2017/4/13 09:55.
 */
public class BaseRecyclerPagePresenter extends BaseRecyclerPresenter {
    protected int mPageSize;
    protected int mPageIndex;

    public BaseRecyclerPagePresenter(Activity activity) {
        super(activity);
    }

    public BaseRecyclerPagePresenter(View view) {
        super(view);
    }

    public BaseRecyclerPagePresenter(View view, @IdRes int recyclerViewId) {
        super(view, recyclerViewId);
    }
}
