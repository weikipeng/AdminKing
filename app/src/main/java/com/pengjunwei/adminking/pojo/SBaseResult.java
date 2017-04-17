package com.pengjunwei.adminking.pojo;

import android.text.TextUtils;
import android.widget.Toast;

import com.google.gson.annotations.SerializedName;
import com.pengjunwei.adminking.MainApplication;
import com.pengjunwei.support.BaseDataBehavior;

/**
 * Created by WikiPeng on 2017/3/21 11:04.
 */
public class SBaseResult extends BaseDataBehavior{
    /**
     * errCode : -1
     * errMsg : 注册码不存在
     */
    @SerializedName("errCode")
    public int    errCode;
    @SerializedName("errMsg")
    public String errMsg;

    @Override
    public boolean handleErrorMessage(String defaultErrorMessage, boolean isIntercept) {
        return handleErrorMessage(defaultErrorMessage, isIntercept, errCode, errMsg);
    }

    public boolean handleErrorMessage(String defaultErrorMessage, boolean isIntercept
            , int errorCode, String errorMessage) {
        if (errorCode != 0) {
            if (!TextUtils.isEmpty(errorMessage)) {
                defaultErrorMessage = errorMessage;
            }

            if (!isIntercept) {
                Toast.makeText(MainApplication.getInstance(), defaultErrorMessage, Toast.LENGTH_SHORT).show();
            }
            return true;
        } else {
            return false;
        }
    }
}
