package com.pengjunwei.adminking.pojo;

import com.google.gson.annotations.SerializedName;
import com.pengjunwei.support.BaseDataListBehavior;

import java.util.List;

/**
 * Created by WikiPeng on 2017/4/14 14:36.
 */
public class SLicenseList extends SBaseListResult{
    public SCorporation corporation;

    @SerializedName("res")
    public List<SLicense> licenseList;

    @Override
    public boolean isEmpty() {
        return licenseList == null || licenseList.size() == 0;
    }

}
