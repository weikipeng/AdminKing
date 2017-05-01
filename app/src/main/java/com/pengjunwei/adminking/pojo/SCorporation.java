package com.pengjunwei.adminking.pojo;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.annotations.SerializedName;

/**
 * Created by WikiPeng on 2017/4/13 10:35.
 */
public class SCorporation extends SBaseResult{
    public static final String TAG = SCorporation.class.getSimpleName();

    /**
     * id : 1
     * name : android
     * createDate : 2017-04-11 16:20:45
     * updateDate : 0000-00-00 00:00:00
     */

    @SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;
    @SerializedName("createDate")
    public String createDate;
    @SerializedName("updateDate")
    public String updateDate;

    public String channel;

//    public static String getChannel(Context context) {
//        String channel = "";
//        try {
//            ApplicationInfo ai     = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
//            Bundle          bundle = ai.metaData;
//            channel = bundle.getString("UMENG_CHANNEL");
//        } catch (PackageManager.NameNotFoundException e) {
//            Log.e(TAG, "Failed to load meta-data, NameNotFound: " + e.getMessage());
//        } catch (NullPointerException e) {
//            Log.e(TAG, "Failed to load meta-data, NullPointer: " + e.getMessage());
//        }
//
//        return channel;
//    }
}
