package com.pengjunwei.adminking.ui.corporation.detail;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pengjunwei.adminking.R;
import com.pengjunwei.adminking.pojo.SLicense;
import com.pengjunwei.android.mvp.IViewParam;
import com.pengjunwei.android.mvp.recyclerview.BaseRecyclerViewHolder;
import com.pengjunwei.android.mvp.recyclerview.ILayoutProvider;

/**
 * Created by WikiPeng on 2017/4/17 10:46.
 */
public class VHCorporationLicense extends BaseRecyclerViewHolder {
    protected TextView content;
    protected TextView btnAction;
    protected TextView status;

    public VHCorporationLicense(View itemView, IViewParam viewParam) {
        super(itemView, viewParam);
        initView();

    }

    protected void initView() {
        content = (TextView) itemView.findViewById(R.id.name);
        btnAction = (TextView) itemView.findViewById(R.id.btnAction);
        status = (TextView) itemView.findViewById(R.id.status);
    }

    @Override
    public void onBindViewHolder(int position, Object data) {
        super.onBindViewHolder(position, data);
        SLicense license = null;
        if (data instanceof SLicense) {
            license = (SLicense) data;
        }

        if (license == null) {
            return;
        }

        content.setText(license.name);
        status.setText(license.isBind ? R.string.bind : R.string.not_bind);
//        status.setTextColor(license.isBind ? Color.RED : itemView.getResources().getColor(R.color.colorText));
        status.setTextColor(license.isBind ? Color.RED : Color.DKGRAY);
    }

    public static class LayoutProvider implements ILayoutProvider {

        @Override
        public BaseRecyclerViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent, IViewParam viewParam) {
            return new VHCorporationLicense(inflater.inflate(R.layout.item_corporation_license, parent, false), viewParam);
        }
    }
}
