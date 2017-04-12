package com.pengjunwei.adminking.ui.login;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.pengjunwei.adminking.R;
import com.pengjunwei.android.mvp.BaseMVPView;
import com.pengjunwei.android.mvp.IMVPProvider;
import com.pengjunwei.android.mvp.IPresenter;
import com.pengjunwei.support.tool.RxSubscriber;

import java.util.concurrent.TimeUnit;

/**
 * Created by WikiPeng on 2017/4/11 20:07.
 */
public class LoginView extends BaseMVPView implements View.OnClickListener {
    protected EditText userName;
    protected EditText password;
    protected TextView btnLogin;

    public <T extends IPresenter> LoginView(IMVPProvider provider, T presenter) {
        super(provider, presenter);
        initView();
        addEvent();
    }

    @Override
    protected void initView() {
        super.initView();
        userName = getMVPProvider().findViewById(R.id.userName);
        password = getMVPProvider().findViewById(R.id.password);
        btnLogin = getMVPProvider().findViewById(R.id.login);
    }

    @Override
    protected void addEvent() {
        super.addEvent();
        RxView.clicks(btnLogin).throttleFirst(300, TimeUnit.MILLISECONDS).
                subscribe(new RxSubscriber<Object>() {
                    @Override
                    public void onNext(Object o) {
                        onClick(btnLogin);
                    }
                });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                String userNameText = userName.getText().toString();
                String passwordText = password.getText().toString();
                if (presenter instanceof ILoginPresenter) {
                    ((ILoginPresenter) presenter).login(userNameText, passwordText);
                }
                break;
        }
    }
}
