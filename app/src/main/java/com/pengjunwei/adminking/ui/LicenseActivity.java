package com.pengjunwei.adminking.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.pengjunwei.adminking.R;
import com.pengjunwei.adminking.ui.license.LicensePresenter;
import com.pengjunwei.android.base.BaseMVPActivity;

/**
 * Created by WikiPeng on 2017/4/12 11:29.
 */
public class LicenseActivity extends BaseMVPActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_license);
        mPresenter = new LicensePresenter(this);
    }
}
