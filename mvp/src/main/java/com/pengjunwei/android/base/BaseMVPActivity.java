package com.pengjunwei.android.base;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.pengjunwei.android.mvp.ILifeCycleListener;
import com.pengjunwei.android.mvp.IPresenter;
import com.pengjunwei.android.mvp.activity.IActivityLifePresenter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by WikiPeng on 2017/3/28 09:12.
 */
public class BaseMVPActivity extends AppCompatActivity{
    protected IPresenter mPresenter;

    @Override
    protected void onResume() {
        super.onResume();
        callPresenterLifeCycle();
    }

    @Override
    protected void onPause() {
        super.onPause();
        callPresenterLifeCycle();
    }

    @Override
    protected void onStop() {
        super.onStop();
        callPresenterLifeCycle();
    }

    @Override
    public void finish() {
        callPresenterLifeCycle();
        super.finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        callPresenterLifeCycle();
    }

    protected void callPresenterLifeCycle() {
        String fullClassName = Thread.currentThread().getStackTrace()[3].getClassName();
        String className     = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
        int    lineNumber    = Thread.currentThread().getStackTrace()[3].getLineNumber();
        String methodName    = Thread.currentThread().getStackTrace()[3].getMethodName(); // output : main


        StringBuilder stringBuilder = new StringBuilder(className);
        stringBuilder.append(" ===> ");
        stringBuilder.append(methodName);
        stringBuilder.append(" ===> ");
        stringBuilder.append("callLifeCycleListeners");
        stringBuilder.append("\t\t\t\t\t\tLine:");
        stringBuilder.append(lineNumber);

        Log.println(Log.ERROR, "wikipeng", stringBuilder.toString());

        if (mPresenter != null) {
            try {
                Method method = ILifeCycleListener.class.getDeclaredMethod(methodName);
                method.invoke(mPresenter);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mPresenter instanceof IActivityLifePresenter) {
            ((IActivityLifePresenter) mPresenter).onActivityResult(requestCode, resultCode, data);
        }
    }
}
