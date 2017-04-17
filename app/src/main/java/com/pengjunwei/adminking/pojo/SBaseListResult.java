package com.pengjunwei.adminking.pojo;

import android.widget.Toast;

import com.pengjunwei.adminking.MainApplication;
import com.pengjunwei.adminking.R;
import com.pengjunwei.support.IDataListBehavior;

/**
 * Created by WikiPeng on 2017/3/21 11:04.
 */
public class SBaseListResult extends SBaseResult implements IDataListBehavior {
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean hasMore() {
        return false;
    }

    @Override
    public boolean handleEmptyMessage(boolean isLoadMore, String errorMessage) {
        if (isEmpty()) {
            if (isLoadMore && !isInterceptNoMoreMessage()) {
                Toast.makeText(MainApplication.getInstance(), errorMessage, Toast.LENGTH_SHORT).show();
            }
            return true;
        }

        return false;
    }

    @Override
    public boolean handleEmptyMessage(boolean isLoadMore) {
        return handleEmptyMessage(isLoadMore, MainApplication.getInstance()
                .getString(R.string.tips_info_no_more_message));
    }

    @Override
    public boolean isInterceptNoMoreMessage() {
        return false;
    }

    @Override
    public <T> boolean add(T data) {
        return false;
    }
}
