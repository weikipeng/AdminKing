package com.pengjunwei.android.mvp;

/**
 * Created by WikiPeng on 2017/3/17 14:43.
 */
public interface ILifeCycleListener {
    void onResume();
    void onPause();
    void onStop();
    void finish();
    void onDestroy();
}
