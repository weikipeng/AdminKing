package com.pengjunwei.support;

import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by WikiPeng on 2017/4/14 17:21.
 */
public abstract class BaseDataBehavior implements IDataBehavior{
    @Override
    public boolean isInterceptShowErrorMessage() {
        return false;
    }

    @Override
    public boolean handleErrorMessage() {
        return handleErrorMessage("服务器返回数据异常");
    }

    @Override
    public boolean handleErrorMessage(String errorMessage) {
        return handleErrorMessage(errorMessage, isInterceptShowErrorMessage());
    }
}
