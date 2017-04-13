package com.pengjunwei.adminking.ui.corporation;

import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.pengjunwei.adminking.R;
import com.pengjunwei.android.mvp.IMVPProvider;
import com.pengjunwei.android.mvp.IPresenter;
import com.pengjunwei.android.mvp.recyclerview.BaseRecyclerMVPView;

import java.util.concurrent.TimeUnit;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by WikiPeng on 2017/4/12 14:58.
 */
public class CorporationView extends BaseRecyclerMVPView {
    public TextView mBtnCreate;
    public EditText mNameEditText;

    public <T extends IPresenter> CorporationView(IMVPProvider provider, T presenter) {
        super(provider, presenter);
    }

    @Override
    protected void initView() {
        super.initView();
        mBtnCreate = provider.findViewById(R.id.btnCreate);
        mNameEditText = provider.findViewById(R.id.nameEditText);
    }

    @Override
    protected void addEvent() {
        super.addEvent();
        RxView.clicks(mBtnCreate).throttleFirst(300, TimeUnit.MILLISECONDS)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        if (presenter instanceof ICorporationPresenter) {
                            ((ICorporationPresenter) presenter).createCorporation(mNameEditText.getEditableText().toString());
                        }
                    }
                });
    }
}
