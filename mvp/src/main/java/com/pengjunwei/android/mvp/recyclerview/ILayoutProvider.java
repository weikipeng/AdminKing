package com.pengjunwei.android.mvp.recyclerview;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.pengjunwei.android.mvp.IViewParam;

/**
 * Created by WikiPeng on 2017/3/11 17:52.
 */
public interface ILayoutProvider {
    BaseRecyclerViewHolder onCreateViewHolder(
            @NonNull LayoutInflater inflater, @NonNull ViewGroup parent, IViewParam viewParam);
}
