package com.pengjunwei.adminking.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.pengjunwei.adminking.R;
import com.pengjunwei.adminking.ui.corporation.CorporationPresenter;
import com.pengjunwei.adminking.ui.corporation.detail.CorporationDetailPresenter;
import com.pengjunwei.android.base.BaseMVPActivity;

/**
 * Created by WikiPeng on 2017/4/12 14:39.
 */
public class CorporationDetailActivity extends BaseMVPActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corporation_detail);
        mPresenter = new CorporationDetailPresenter(this);
        mPresenter.setIntent(getIntent());
        mPresenter.refresh(true);
    }
}
