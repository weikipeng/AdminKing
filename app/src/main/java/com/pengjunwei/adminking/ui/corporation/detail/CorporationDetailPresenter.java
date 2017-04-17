package com.pengjunwei.adminking.ui.corporation.detail;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;

import com.pengjunwei.adminking.interactor.CorporationInteractor;
import com.pengjunwei.adminking.interactor.LicenseInteractor;
import com.pengjunwei.adminking.pojo.SCorporation;
import com.pengjunwei.adminking.pojo.SLicense;
import com.pengjunwei.adminking.pojo.SLicenseList;
import com.pengjunwei.adminking.ui.corporation.CorporationAction;
import com.pengjunwei.adminking.ui.corporation.CorporationView;
import com.pengjunwei.adminking.ui.corporation.VHCorporation;
import com.pengjunwei.android.mvp.recyclerview.BaseRecyclerAdapter;
import com.pengjunwei.android.mvp.recyclerview.BaseRecyclerPagePresenter;
import com.pengjunwei.android.mvp.recyclerview.IRecyclerView;
import com.pengjunwei.support.tool.RxSubscriber;

/**
 * Created by WikiPeng on 2017/4/14 10:43.
 */
public class CorporationDetailPresenter extends BaseRecyclerPagePresenter implements ICorporationDetailPresenter{
    protected CorporationAction mCorporationAction;
    protected CorporationInteractor.Interactor mInteractor;
    protected LicenseInteractor.Interactor mLicenseInteractor;

    public CorporationDetailPresenter(Activity activity) {
        super(activity);
        mvpView = new CorporationDetailView(provider, this);
        initData();
    }

    @Override
    protected void initData() {
        super.initData();
        initViewParam();
        mAdapter = new BaseRecyclerAdapter(mViewParam);
        ((IRecyclerView) mvpView).setAdapter(mAdapter);
        mInteractor = new CorporationInteractor.InteractorImpl();
        mLicenseInteractor = new LicenseInteractor.InteractorImpl();
        mAdapter.getTypeProvider().register(SLicense.class, VHCorporationLicense.class, new VHCorporationLicense.LayoutProvider());
    }

    @Override
    public void setIntent(Intent intent) {
        super.setIntent(intent);
        mCorporationAction = CorporationAction.from(intent);
    }

    @Override
    public void refresh(boolean isForce) {
        super.refresh(isForce);
        if (mCorporationAction != null) {
            mInteractor.getDetail(mCorporationAction.id).subscribe(new RxSubscriber<SLicenseList>() {
                @Override
                public void onNext(SLicenseList result) {
                    handleLicenseListResult(result);
                }
            });
        }
    }

    protected void handleLicenseListResult(SLicenseList result) {
        if (result == null) {
            result = new SLicenseList();
        }

        if (result.handleErrorMessage()) {
            return;
        }

        if (result.handleEmptyMessage(mPageIndex > 0)) {
            mvpView.showEmptyView(true);
            provider.showToast("没有数据显示");
            return;
        }

        mvpView.showEmptyView(false);
        mAdapter.add(result.licenseList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void createLicense(int num) {
        mLicenseInteractor.create(mCorporationAction.id,num).subscribe(new RxSubscriber<SLicenseList>() {
            @Override
            public void onNext(SLicenseList result) {
                handleLicenseListResult(result);
            }
        });
    }
}
