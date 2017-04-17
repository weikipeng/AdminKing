package com.pengjunwei.support;

/**
 * Created by WikiPeng on 2017/4/14 17:21.
 */
public abstract class BaseDataListBehavior extends BaseDataBehavior implements IDataListBehavior {
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
        return false;
    }

    @Override
    public boolean handleEmptyMessage(boolean isLoadMore) {
        return false;
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
