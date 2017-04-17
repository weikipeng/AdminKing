package com.pengjunwei.adminking;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.facebook.stetho.Stetho;
import com.pengjunwei.adminking.base.BaseInteractor;

/**
 * Created by WikiPeng on 2017/3/27 18:11.
 */
public class MainApplication extends Application {
    protected static MainApplication sMainApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        sMainApplication = this;
        TypefaceProvider.registerDefaultIconSets();
        Stetho.initializeWithDefaults(this);
        BaseInteractor.init(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static MainApplication getInstance() {
        return sMainApplication;
    }
}
