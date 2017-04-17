package com.pengjunwei.adminking.ui.corporation.detail;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pengjunwei.adminking.R;
import com.pengjunwei.adminking.pojo.SCorporation;
import com.pengjunwei.adminking.pojo.SLicense;
import com.pengjunwei.android.mvp.IViewParam;
import com.pengjunwei.android.mvp.recyclerview.BaseRecyclerViewHolder;
import com.pengjunwei.android.mvp.recyclerview.ILayoutProvider;

import org.w3c.dom.Text;

/**
 * Created by WikiPeng on 2017/4/17 10:46.
 */
public class VHCorporationLicense extends BaseRecyclerViewHolder{
    protected TextView content;
    protected TextView btnAction;
    public VHCorporationLicense(View itemView, IViewParam viewParam) {
        super(itemView, viewParam);
        initView();

    }

    protected void initView() {
        content = (TextView) itemView.findViewById(R.id.name);
        btnAction = (TextView) itemView.findViewById(R.id.btnAction);
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
    }

    public static class LayoutProvider implements ILayoutProvider{

        @Override
        public BaseRecyclerViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent, IViewParam viewParam) {
            return new VHCorporationLicense(inflater.inflate(R.layout.item_corporation_license, parent, false), viewParam);
        }
    }
}
