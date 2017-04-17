package com.pengjunwei.adminking.interactor;

import com.pengjunwei.adminking.base.BaseInteractor;
import com.pengjunwei.adminking.pojo.SCorporation;
import com.pengjunwei.adminking.pojo.SCorporationList;
import com.pengjunwei.adminking.pojo.SLicenseList;
import com.pengjunwei.support.tool.RxSchedulersHelper;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by WikiPeng on 2017/4/13 09:26.
 */
public class CorporationInteractor extends BaseInteractor {
    public interface WebInterface {
        @GET("/kingmath/corporation/list.php")
        Observable<SCorporationList> getList(@Query("offset") int offset, @Query("limit") int limit);

        @POST("/kingmath/corporation/add.php")
        @FormUrlEncoded
        Observable<SCorporation> add(@Field("name") String name);

        @POST("/kingmath/corporation/detail.php")
        @FormUrlEncoded
        Observable<SLicenseList> getDetail(@Field("id") int id);
    }

    public interface Interactor {
        Observable<SCorporationList> getList(int pageIndex, int pageSize);

        Observable<SCorporation> add(String name);

        Observable<SLicenseList> getDetail(int id);
    }

    public static class InteractorImpl implements Interactor {
        WebInterface webInterface = createService(WebInterface.class, BaseInteractor.BASE_URL);

        @Override
        public Observable<SCorporationList> getList(int pageIndex, int pageSize) {
            return webInterface.getList(pageIndex * pageIndex, pageSize)
                    .compose(RxSchedulersHelper.<SCorporationList>applyMainSchedulers());
        }

        @Override
        public Observable<SCorporation> add(String name) {
            return webInterface.add(name).compose(RxSchedulersHelper.<SCorporation>applyMainSchedulers());
        }

        @Override
        public Observable<SLicenseList> getDetail(int id) {
            return webInterface.getDetail(id).compose(RxSchedulersHelper.<SLicenseList>applyMainSchedulers());
        }
    }
}
