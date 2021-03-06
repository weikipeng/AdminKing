package com.pengjunwei.support.tool;


import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 处理Rx线程
 * Created by YoKey.
 */
public class RxSchedulersHelper {

    protected final static ObservableTransformer ioSchedulersTransformer   =
            new ObservableTransformer<Observable, Observable>() {
                @Override
                public ObservableSource<Observable> apply(Observable<Observable> upstream) {
                    return upstream.subscribeOn(Schedulers.io())
                            .unsubscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread());
                }
            };
    protected final static ObservableTransformer mainSchedulersTransformer =
            new ObservableTransformer<Observable, Observable>() {
                @Override
                public ObservableSource<Observable> apply(Observable<Observable> upstream) {
                    return upstream.subscribeOn(Schedulers.io())
                            .unsubscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread());
                }
            };


    public static <T> ObservableTransformer<T, T> applyMainSchedulers() {
        return mainSchedulersTransformer;
    }

    public static <T> ObservableTransformer<T, T> applyIOSchedulers() {
        return ioSchedulersTransformer;
    }
}