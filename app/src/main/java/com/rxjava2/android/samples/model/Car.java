package com.rxjava2.android.samples.model;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by amitshekhar on 30/08/16.
 */
public class Car {

    private String brand;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Observable<String> brandDeferObservable() {
       return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext(brand);
                e.onComplete();
            }
        });
//        return Observable.defer(new Callable<ObservableSource<? extends String>>() {
//            @Override
//            public ObservableSource<? extends String> call() throws Exception {
//                return Observable.just(brand);
//            }
//        });
    }

}
