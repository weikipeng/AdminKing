package com.pengjunwei.adminking.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.pengjunwei.android.base.BaseMVPActivity;
import com.pengjunwei.support.base.BaseActivity;

/**
 * Created by WikiPeng on 2017/3/27 18:11.
 */
public class SplashActivity extends BaseMVPActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
