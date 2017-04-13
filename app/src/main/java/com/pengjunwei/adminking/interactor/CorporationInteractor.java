package com.pengjunwei.adminking.interactor;

import com.pengjunwei.adminking.base.BaseInteractor;
import com.pengjunwei.adminking.pojo.SCorporationList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by WikiPeng on 2017/4/13 09:26.
 */
public class CorporationInteractor extends BaseInteractor {
    public interface WebInterface {
        @GET("/kingmath/corporation/list.php")
        Observable<SCorporationList> getList(@Query("offset") int offset, @Query("limit") int limit);
    }

    public interface Interactor {
        Observable<SCorporationList> getList(int pageIndex, int pageSize);
    }

    public static class InteractorImpl implements Interactor {
        WebInterface webInterface = createService(WebInterface.class, BaseInteractor.BASE_URL);


        @Override
        public Observable<SCorporationList> getList(int pageIndex, int pageSize) {
            return null;
        }
    }
}
