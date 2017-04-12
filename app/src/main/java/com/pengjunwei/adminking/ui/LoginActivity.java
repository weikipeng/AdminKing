package com.pengjunwei.adminking.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.pengjunwei.adminking.R;
import com.pengjunwei.adminking.ui.login.LoginPresenter;
import com.pengjunwei.android.base.BaseMVPActivity;

/**
 * Created by WikiPeng on 2017/4/11 17:16.
 */
public class LoginActivity extends BaseMVPActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        mPresenter = new LoginPresenter(this);
    }
}
