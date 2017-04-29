package com.pengjunwei.adminking.ui.corporation;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.pengjunwei.adminking.R;
import com.pengjunwei.adminking.pojo.SCorporation;
import com.pengjunwei.android.mvp.IViewParam;
import com.pengjunwei.android.mvp.recyclerview.BaseRecyclerViewHolder;
import com.pengjunwei.android.mvp.recyclerview.ILayoutProvider;
import com.pengjunwei.support.tool.RxSubscriber;

import java.util.concurrent.TimeUnit;

/**
 * Created by WikiPeng on 2017/4/13 10:36.
 */
public class VHCorporation extends BaseRecyclerViewHolder {

    protected TextView name;
    protected TextView createTime;
    protected TextView btnAction;
    //    protected TextView updateTime;

    public VHCorporation(View itemView, IViewParam viewParam) {
        super(itemView, viewParam);
        initView();
        addEvent();
        //        btnAction.setOnClickListener(viewParam);
    }

    protected void initView() {
        name = (TextView) itemView.findViewById(R.id.name);
        createTime = (TextView) itemView.findViewById(R.id.createTime);
        btnAction = (TextView) itemView.findViewById(R.id.btnAction);
        //        updateTime = (TextView) itemView.findViewById(R.id.updateTime);
    }

    @Override
    protected void addEvent() {
        super.addEvent();
        if (mViewParam instanceof IViewParamCorporation) {
            RxView.clicks(btnAction).throttleFirst(300, TimeUnit.MILLISECONDS)
                    .subscribe(new RxSubscriber() {
                        @Override
                        public void onNext(Object o) {
                            ((IViewParamCorporation) mViewParam).onManageCorporationClick(getAdapterPosition(), VHCorporation.this, mData);
                        }
                    });
        }
    }

    @Override
    public void onBindViewHolder(int position, Object data) {
        super.onBindViewHolder(position, data);
        SCorporation corporation = null;
        if (data instanceof SCorporation) {
            corporation = (SCorporation) data;
        }

        if (corporation == null) {
            return;
        }

        name.setText(corporation.name);
        createTime.setText(corporation.createDate);
        //        updateTime.setText(corporation.updateDate);
    }

    public static class LayoutProvider implements ILayoutProvider {

        @Override
        public VHCorporation onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent, IViewParam viewParam) {
            return new VHCorporation(inflater.inflate(R.layout.item_corporation, parent, false), viewParam);
        }
    }
}
