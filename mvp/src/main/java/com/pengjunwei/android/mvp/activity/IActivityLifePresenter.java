package com.pengjunwei.android.mvp.activity;

import android.content.Intent;

import com.pengjunwei.android.mvp.ILifeCycleListener;

/**
 * Created by WikiPeng on 2017/3/17 16:57.
 */
public interface IActivityLifePresenter extends ILifeCycleListener {
    void onActivityResult(int requestCode, int resultCode, Intent data);
}
