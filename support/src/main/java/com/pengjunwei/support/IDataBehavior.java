package com.pengjunwei.support;

/**
 * Created by WikiPeng on 2017/4/14 17:12.
 */
public interface IDataBehavior {
    /**
     * 是否拦截显示错误信息
     */
    boolean isInterceptShowErrorMessage();

    /**
     * 处理错误信息
     */
    boolean handleErrorMessage();

    boolean handleErrorMessage(String errorMessage);

    boolean handleErrorMessage(String defaultErrorMessage, boolean isIntercept);
}
