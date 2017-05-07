package com.pengjunwei.adminking.interactor;

import com.pengjunwei.adminking.base.BaseInteractor;
import com.pengjunwei.adminking.pojo.SCorporation;
import com.pengjunwei.adminking.pojo.SLicenseList;
import com.pengjunwei.support.tool.RxSchedulersHelper;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by WikiPeng on 2017/4/17 10:27.
 */
public class LicenseInteractor extends BaseInteractor {
    public interface WebInterface {
        //http://localhost/kingmath/license/create.php
        @POST("/kingmath/license/create.php")
        @FormUrlEncoded
        Observable<SLicenseList> create(@Field("c") int id,@Field("channel") String channel
                ,@Field("num") int num,@Field("s") String sign);
    }

    public interface Interactor {
        Observable<SLicenseList> create(int id,String channel,int num);
    }

    public static class InteractorImpl implements Interactor {
        WebInterface webInterface = createService(WebInterface.class, BaseInteractor.BASE_URL);

        @Override
        public Observable<SLicenseList> create(int id,String channel,int num) {
            return webInterface.create(id,channel,num,"").compose(RxSchedulersHelper.<SLicenseList>applyMainSchedulers());
        }
    }
}
