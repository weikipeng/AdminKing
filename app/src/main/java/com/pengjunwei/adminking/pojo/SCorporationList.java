package com.pengjunwei.adminking.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by WikiPeng on 2017/4/13 09:41.
 */
public class SCorporationList extends SBaseResult {
    @SerializedName("res")
    public List<SCorporation> corporationList;
}
