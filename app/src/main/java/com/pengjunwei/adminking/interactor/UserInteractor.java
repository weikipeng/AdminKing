package com.pengjunwei.adminking.interactor;

import android.util.Base64;

import com.pengjunwei.adminking.base.BaseInteractor;
import com.pengjunwei.adminking.pojo.SLoginResult;
import com.pengjunwei.support.tool.DateTool;
import com.pengjunwei.support.tool.MD5;
import com.pengjunwei.support.tool.RxSchedulersHelper;

import java.io.UnsupportedEncodingException;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by WikiPeng on 2017/4/11 20:05.
 */
public class UserInteractor extends BaseInteractor {
    private interface WebInterface {
        /***/
        @POST("/kingmath/user/login.php")
        @FormUrlEncoded
        Observable<SLoginResult> login(@Field("userName") String userName, @Field("password") String password, @Field("s") String sign);

    }

    public interface Interactor {
        Observable<SLoginResult> login(String userName, String password);
    }

    public static class InteractorImpl implements Interactor {
        WebInterface webInterface = createService(WebInterface.class, BASE_URL);

        @Override
        public Observable<SLoginResult> login(String userName, String password) {
            return webInterface.login(userName, password, getSign(userName, password)).compose(RxSchedulersHelper.<SLoginResult>applyMainSchedulers());
        }

        protected String getSign(String userName, String password) {
            String result = "CK4APBVXAS9WDW34H163TRJDT5PSJK";
            String date   = DateTool.getYMD();
            String name   = "";
            try {
                name = Base64.encodeToString(userName.getBytes("utf-8"), Base64.NO_WRAP);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            result = result + date + name + password;
            result = MD5.md5(result);
            return result;
        }
    }
}
