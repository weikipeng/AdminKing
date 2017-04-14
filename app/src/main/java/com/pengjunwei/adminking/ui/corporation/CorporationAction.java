package com.pengjunwei.adminking.ui.corporation;

import android.content.Context;
import android.content.Intent;

import com.pengjunwei.adminking.ui.CorporationDetailActivity;

import static com.pengjunwei.adminking.Constants.*;

/**
 * Created by WikiPeng on 2017/4/14 10:45.
 */
public class CorporationAction {
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
        intent.putExtra(PARAM_ID, id);
        return intent;
    }

    public static CorporationAction create(int id) {
        CorporationAction result = new CorporationAction(id);
        return result;
    }
}
