package com.pengjunwei.adminking.ui.license;

import android.app.Activity;

import com.pengjunwei.android.mvp.recyclerview.BaseRecyclerPresenter;

/**
 * Created by WikiPeng on 2017/4/12 13:42.
 */
public class LicensePresenter extends BaseRecyclerPresenter {
    public LicensePresenter(Activity activity) {
        super(activity);
        initData();
        mvpView = new LicenseView(provider, this);
    }
}
