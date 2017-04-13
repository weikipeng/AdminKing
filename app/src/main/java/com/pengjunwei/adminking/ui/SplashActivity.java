package com.pengjunwei.adminking.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

import com.pengjunwei.adminking.base.BaseInteractor;
import com.pengjunwei.android.base.BaseMVPActivity;

/**
 * Created by WikiPeng on 2017/3/27 18:11.
 */
public class SplashActivity extends BaseMVPActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (sharedPreferences.contains(BaseInteractor.PARAM_AUTHORIZATION)) {
            startActivity(new Intent(this, CorporationActivity.class));
        } else {
            startActivity(new Intent(this, LoginActivity.class));
        }

        finish();
    }
}
