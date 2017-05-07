package com.pengjunwei.adminking.ui.corporation;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.jakewharton.rxbinding2.widget.SeekBarChangeEvent;
import com.pengjunwei.adminking.R;
import com.pengjunwei.adminking.base.BaseInteractor;
import com.pengjunwei.adminking.interactor.CorporationInteractor;
import com.pengjunwei.adminking.pojo.SCorporation;
import com.pengjunwei.adminking.pojo.SCorporationList;
import com.pengjunwei.android.mvp.recyclerview.BaseRecyclerAdapter;
import com.pengjunwei.android.mvp.recyclerview.BaseRecyclerPagePresenter;
import com.pengjunwei.android.mvp.recyclerview.IRecyclerView;
import com.pengjunwei.support.tool.RxSubscriber;

import java.io.UnsupportedEncodingException;

/**
 * Created by WikiPeng on 2017/4/12 14:58.
 */
public class CorporationPresenter extends BaseRecyclerPagePresenter implements ICorporationPresenter, IViewParamCorporation {
    protected CorporationInteractor.Interactor mInteractor;

    //    protected View.OnClickListener

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
        initViewParam();
        mAdapter = new BaseRecyclerAdapter(mViewParam);
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

    @Override
    public void createCorporation(String name) {
        if (TextUtils.isEmpty(name)) {
            provider.showToast("请输入客户名字");
            return;
        }

        mInteractor.add(name).subscribe(new RxSubscriber<SCorporation>() {
            @Override
            public void onNext(SCorporation result) {
                handleCreateResult(result);
            }
        });
    }

    protected void handleCreateResult(SCorporation result) {
        if (result == null) {
            provider.showToast("添加客户失败");
        } else {
            provider.showToast("添加客户成功");
            mAdapter.add(result);
            mAdapter.notifyItemInserted(mAdapter.getItemCount() - 1);
        }
    }

    @Override
    public void onRecyclerViewItemClick(int position, RecyclerView.ViewHolder viewHolder, Object data) {
        if (data instanceof SCorporation) {
            int id = ((SCorporation) data).id;
            String channel = ((SCorporation) data).channel;
            CorporationAction.create(id,channel).startActivity(provider.getActivity());
        }
    }

    protected void shareLicenseCode(SCorporation corporation) {
        // Gets a handle to the clipboard service.
        ClipboardManager clipboard = (ClipboardManager)
                provider.getActivity().getSystemService(Context.CLIPBOARD_SERVICE);

        JsonObject licenseObject = new JsonObject();
        licenseObject.addProperty("license", corporation.createDate);
        licenseObject.addProperty("channel", "b01");

        String paramString = licenseObject.toString();

        try {
            paramString = Base64.encodeToString(paramString.getBytes("utf-8"), Base64.NO_WRAP);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // Creates a new text clip to put on the clipboard
        ClipData clip = ClipData.newPlainText("king license", provider.getActivity().getString(R.string.share_license
                , corporation.name, paramString));
        // Set the clipboard's primary clip.
        clipboard.setPrimaryClip(clip);

        Toast.makeText(provider.getActivity(), "激活邀请码已经复制到剪贴板", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onManageCorporationClick(int position, RecyclerView.ViewHolder viewHolder, Object data) {
        if (data instanceof SCorporation) {
            shareLicenseCode((SCorporation) data);
        }
    }

    @Override
    public void onDownloadLinkClick(int position, RecyclerView.ViewHolder viewHolder, Object data) {
        Toast.makeText(provider.getActivity(), "下载链接已经复制到剪贴板", Toast.LENGTH_SHORT).show();
    }
}