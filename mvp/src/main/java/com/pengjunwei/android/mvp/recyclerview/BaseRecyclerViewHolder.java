package com.pengjunwei.android.mvp.recyclerview;

import android.support.annotation.CallSuper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jakewharton.rxbinding2.view.RxView;
import com.pengjunwei.android.mvp.IViewParam;

import java.util.concurrent.TimeUnit;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by WikiPeng on 2017/3/11 15:59.
 */
public abstract class BaseRecyclerViewHolder extends RecyclerView.ViewHolder {
    protected Object     mData;
    protected IViewParam mViewParam;

    public BaseRecyclerViewHolder(View itemView, IViewParam viewParam) {
        super(itemView);
        this.mViewParam = viewParam;
    }

    protected void addEvent() {
        if (mViewParam instanceof IViewParamRecyclerView) {
            RxView.clicks(itemView).throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new Consumer<Object>() {
                @Override
                public void accept(@NonNull Object o) throws Exception {
                    ((IViewParamRecyclerView) mViewParam).onRecyclerViewItemClick(getAdapterPosition(), BaseRecyclerViewHolder.this, mData);
                }
            });

            if (((IViewParamRecyclerView) mViewParam).isRecyclerViewItemLongClickable(getAdapterPosition(), BaseRecyclerViewHolder.this, mData)) {
                RxView.longClicks(itemView).throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        ((IViewParamRecyclerView) mViewParam).onRecyclerViewItemLongClick(getAdapterPosition() , BaseRecyclerViewHolder.this, mData);
                    }
                });
            }
        }
    }


    @CallSuper
    public void onBindViewHolder(int position, Object data) {
        this.mData = data;
    }
}
