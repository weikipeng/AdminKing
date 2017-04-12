package com.pengjunwei.adminking.ui.corporation;

import com.pengjunwei.android.mvp.IMVPProvider;
import com.pengjunwei.android.mvp.IPresenter;
import com.pengjunwei.android.mvp.recyclerview.BaseRecyclerMVPView;

/**
 * Created by WikiPeng on 2017/4/12 14:58.
 */
public class CorporationView extends BaseRecyclerMVPView {

    public <T extends IPresenter> CorporationView(IMVPProvider provider, T presenter) {
        super(provider, presenter);
    }
}
