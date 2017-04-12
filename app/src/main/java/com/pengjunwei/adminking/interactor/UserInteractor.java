package com.pengjunwei.adminking.interactor;

import com.pengjunwei.adminking.base.BaseInteractor;
import com.pengjunwei.adminking.pojo.SLoginResult;
import com.pengjunwei.support.tool.RxSchedulersHelper;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by WikiPeng on 2017/4/11 20:05.
 */
public class UserInteractor extends BaseInteractor{
    private interface WebInterface {
        /***/
        @POST("/kingmath/user/login.php")
        @FormUrlEncoded
        Observable<SLoginResult> login(@Field("userName") String userName
                , @Field("password") String password, @Field("s") String sign);

    }

    public interface Interactor {
        Observable<SLoginResult> login(String userName, String password);
    }

    public static class InteractorImpl implements Interactor {
        WebInterface webInterface = createService(WebInterface.class, BASE_URL);

        @Override
        public Observable<SLoginResult> login(String userName, String password) {
            return webInterface.login(userName, password, "112233")
                    .compose(RxSchedulersHelper.<SLoginResult>applyMainSchedulers());
        }
    }
}
