package com.pengjunwei.adminking.ui.corporation;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

import com.pengjunwei.adminking.ui.CorporationDetailActivity;

import static com.pengjunwei.adminking.Constants.*;

/**
 * Created by WikiPeng on 2017/4/14 10:45.
 */
public class CorporationAction implements Parcelable {
    public int id;

    private CorporationAction(int id) {
        this.id = id;
    }

    public void startActivity(Context context) {
        if (context == null) {
            return;
        }

        context.startActivity(makeIntent(context, CorporationDetailActivity.class));
    }

    public Intent makeIntent(Context context, Class clazz) {
        Intent intent = new Intent(context, clazz);
        intent.putExtra(PARAM_DATA, this);
        return intent;
    }

    public static CorporationAction create(int id) {
        CorporationAction result = new CorporationAction(id);
        return result;
    }

    public static CorporationAction from(Intent intent) {
        if (intent != null) {
            return intent.getParcelableExtra(PARAM_DATA);
        }
        return null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
    }

    protected CorporationAction(Parcel in) {
        this.id = in.readInt();
    }

    public static final Parcelable.Creator<CorporationAction> CREATOR = new Parcelable.Creator<CorporationAction>() {
        @Override
        public CorporationAction createFromParcel(Parcel source) {
            return new CorporationAction(source);
        }

        @Override
        public CorporationAction[] newArray(int size) {
            return new CorporationAction[size];
        }
    };
}
