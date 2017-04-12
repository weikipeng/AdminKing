package com.pengjunwei.adminking.ui.login;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;

import com.pengjunwei.adminking.base.BaseInteractor;
import com.pengjunwei.adminking.interactor.UserInteractor;
import com.pengjunwei.adminking.pojo.SLoginResult;
import com.pengjunwei.adminking.ui.CorporationActivity;
import com.pengjunwei.android.mvp.activity.BaseActivityPresenter;
import com.pengjunwei.support.tool.FOpenLog;
import com.pengjunwei.support.tool.RxSubscriber;

import java.io.UnsupportedEncodingException;

/**
 * Created by WikiPeng on 2017/4/11 20:05.
 */
public class LoginPresenter extends BaseActivityPresenter implements ILoginPresenter {
    protected UserInteractor.Interactor mInteractor;
    protected SharedPreferences         mSharedPreferences;

    public LoginPresenter(Activity activity) {
        super(activity);
        initData();
        mvpView = new LoginView(provider, this);
    }

    @Override
    protected void initData() {
        super.initData();
        mInteractor = new UserInteractor.InteractorImpl();
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(provider.getActivity());
    }

    @Override
    public void login(String userName, String password) {
        if (TextUtils.isEmpty(userName)) {
            Toast.makeText(provider.getActivity(), "请输入用户名", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(provider.getActivity(), "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        mInteractor.login(userName, password).subscribe(new RxSubscriber<SLoginResult>() {

            @SuppressLint("CommitPrefEdits")
            @Override
            public void onNext(SLoginResult result) {
                handleLoginResult(result);
            }
        });
    }

    protected void handleLoginResult(SLoginResult result) {
        boolean isSuccess = false;
        if (result != null) {
            FOpenLog.e("result===>" + BaseInteractor.sGson.toJson(result));
            if (!TextUtils.isEmpty(result.res)) {
                mSharedPreferences.edit().putString(BaseInteractor.PARAM_AUTHORIZATION, result.res).apply();
                BaseInteractor.sAuthorization = result.res;
                String deResult = null;
                try {
                    deResult = new String(Base64.decode(result.res, Base64.NO_WRAP), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                FOpenLog.e("deResult===>" + deResult);
                isSuccess = true;
            }
        }

        if (!isSuccess) {
            Toast.makeText(provider.getActivity(), "登录失败，请重试", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(provider.getActivity(), "登录成功！", Toast.LENGTH_SHORT).show();
            provider.getActivity().startActivity(new Intent(provider.getActivity(), CorporationActivity.class));
            provider.getActivity().finish();
        }

//        if (mLoginListener != null) {
//            mLoginListener.onLogin(isSuccess);
//        }
    }
}
