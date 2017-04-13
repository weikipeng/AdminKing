package com.pengjunwei.support;

/**
 * Created by WikiPeng on 2017/3/9 18:26.
 */
public interface IDataListBehavior {
    /**
     * 数据是否为空
     */
    boolean isEmpty();
    /**
     * 是否还有更多数据
     */
    boolean hasMore();

    boolean isInterceptShowErrorMessage();

    /**
     * 处理错误信息
     */
    boolean handleErrorMessage();

    boolean handleErrorMessage(String errorMessage);

    boolean handleErrorMessage(String defaultErrorMessage, boolean isIntercept);

    boolean handleEmptyMessage(boolean isLoadMore, String errorMessage);

    boolean handleEmptyMessage(boolean isLoadMore);

    boolean isInterceptNoMoreMessage();

    <T> boolean add(T data);
}