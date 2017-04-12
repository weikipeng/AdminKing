package com.pengjunwei.adminking.ui.license;

import com.pengjunwei.android.mvp.IMVPProvider;
import com.pengjunwei.android.mvp.IPresenter;
import com.pengjunwei.android.mvp.recyclerview.BaseRecyclerMVPView;

/**
 * Created by WikiPeng on 2017/4/12 13:41.
 */
public class LicenseView extends BaseRecyclerMVPView {

    public <T extends IPresenter> LicenseView(IMVPProvider provider, T presenter) {
        super(provider, presenter);
    }
}
