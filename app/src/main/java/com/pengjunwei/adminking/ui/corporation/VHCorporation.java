package com.pengjunwei.adminking.ui.corporation;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pengjunwei.adminking.R;
import com.pengjunwei.adminking.pojo.SCorporation;
import com.pengjunwei.android.mvp.IViewParam;
import com.pengjunwei.android.mvp.recyclerview.BaseRecyclerViewHolder;
import com.pengjunwei.android.mvp.recyclerview.ILayoutProvider;

/**
 * Created by WikiPeng on 2017/4/13 10:36.
 */
public class VHCorporation extends BaseRecyclerViewHolder {

    protected TextView name;
    protected TextView createTime;
    protected TextView updateTime;

    public VHCorporation(View itemView, IViewParam viewParam) {
        super(itemView, viewParam);
        initView();
    }

    protected void initView() {
        name = (TextView) itemView.findViewById(R.id.name);
        createTime = (TextView) itemView.findViewById(R.id.createTime);
        updateTime = (TextView) itemView.findViewById(R.id.updateTime);
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
        updateTime.setText(corporation.updateDate);
    }

    public static class LayoutProvider implements ILayoutProvider {

        @Override
        public VHCorporation onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent, IViewParam viewParam) {
            return new VHCorporation(inflater.inflate(R.layout.layout_corporation, parent, false), viewParam);
        }
    }
}
