package com.pengjunwei.adminking.ui.corporation;

import android.app.Activity;

import com.pengjunwei.adminking.base.BaseInteractor;
import com.pengjunwei.adminking.interactor.CorporationInteractor;
import com.pengjunwei.adminking.pojo.SCorporation;
import com.pengjunwei.adminking.pojo.SCorporationList;
import com.pengjunwei.android.mvp.recyclerview.BaseRecyclerAdapter;
import com.pengjunwei.android.mvp.recyclerview.BaseRecyclerPagePresenter;
import com.pengjunwei.android.mvp.recyclerview.IRecyclerView;
import com.pengjunwei.support.tool.RxSubscriber;

/**
 * Created by WikiPeng on 2017/4/12 14:58.
 */
public class CorporationPresenter extends BaseRecyclerPagePresenter {
    protected CorporationInteractor.Interactor mInteractor;

    public CorporationPresenter(Activity activity) {
        super(activity);
        mvpView = new CorporationView(provider, this);
        initData();
    }

    @Override
    protected void initData() {
        super.initData();
        mPageSize = BaseInteractor.PAGE_SIZE;
        mInteractor = new CorporationInteractor.InteractorImpl();
        mAdapter = new BaseRecyclerAdapter();
        mAdapter.getTypeProvider().register(SCorporation.class, VHCorporation.class, new VHCorporation.LayoutProvider());
        ((IRecyclerView) mvpView).setAdapter(mAdapter);
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

        if (result.corporationList != null && result.corporationList.size() > 0) {
            int position = mAdapter.getItemCount();
            mAdapter.add(result.corporationList);
            mAdapter.notifyItemRangeInserted(position, result.corporationList.size());
        }
    }
}
