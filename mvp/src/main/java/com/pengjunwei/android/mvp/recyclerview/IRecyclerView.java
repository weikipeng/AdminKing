package com.pengjunwei.android.mvp.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by WikiPeng on 2017/3/11 15:31.
 */
public interface IRecyclerView {
    void setAdapter(RecyclerView.Adapter adapter);

    int getPositionByView(View view);
}
