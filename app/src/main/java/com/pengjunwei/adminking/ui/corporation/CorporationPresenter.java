package com.pengjunwei.adminking.ui.corporation;

import android.app.Activity;

import com.pengjunwei.adminking.base.BaseInteractor;
import com.pengjunwei.adminking.interactor.CorporationInteractor;
import com.pengjunwei.adminking.pojo.SCorporationList;
import com.pengjunwei.android.mvp.recyclerview.BaseRecyclerPagePresenter;
import com.pengjunwei.support.tool.RxSubscriber;

/**
 * Created by WikiPeng on 2017/4/12 14:58.
 */
public class CorporationPresenter extends BaseRecyclerPagePresenter {
    protected CorporationInteractor.Interactor mInteractor;

    public CorporationPresenter(Activity activity) {
        super(activity);
        initData();
        mvpView = new CorporationView(provider, this);
    }

    @Override
    protected void initData() {
        super.initData();
        mPageSize = BaseInteractor.PAGE_SIZE;
        mInteractor = new CorporationInteractor.InteractorImpl();
    }

    @Override
    public void refresh(boolean isForce) {
        super.refresh(isForce);
        mInteractor.getList(mPageIndex, mPageSize).subscribe(new RxSubscriber<SCorporationList>() {
            @Override
            public void onNext(SCorporationList result) {
                handleCorporationList(result);
            }
        });
    }

    protected void handleCorporationList(SCorporationList result) {
        if (result == null) {
            result = new SCorporationList();
        }
    }
}
