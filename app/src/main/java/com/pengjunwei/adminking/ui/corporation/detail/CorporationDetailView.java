package com.pengjunwei.adminking.ui.corporation.detail;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.pengjunwei.adminking.R;
import com.pengjunwei.android.mvp.IMVPProvider;
import com.pengjunwei.android.mvp.IPresenter;
import com.pengjunwei.android.mvp.recyclerview.BaseRecyclerMVPView;

/**
 * Created by WikiPeng on 2017/4/14 10:43.
 */
public class CorporationDetailView extends BaseRecyclerMVPView implements View.OnClickListener {
    protected EditText mNum;
    protected TextView mBtnCreate;

    public <T extends IPresenter> CorporationDetailView(IMVPProvider provider, T presenter) {
        super(provider, presenter);
    }

    @Override
    protected void initView() {
        super.initView();
        mBtnCreate = provider.findViewById(R.id.btnCreate);
        mNum = provider.findViewById(R.id.numberEditText);
    }

    @Override
    protected void addEvent() {
        super.addEvent();
        mBtnCreate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCreate:
                String num = mNum.getEditableText().toString();
                if (TextUtils.isEmpty(num)) {
                    provider.showToast("请输入注册码个数");
                    return;
                }
                if (!TextUtils.isDigitsOnly(num)) {
                    provider.showToast("注册码输入非法，不是数字");
                    return;
                }

                if (presenter instanceof ICorporationDetailPresenter) {
                    ((ICorporationDetailPresenter) presenter).createLicense(Integer.parseInt(num));
                }
                break;
        }
    }
}
