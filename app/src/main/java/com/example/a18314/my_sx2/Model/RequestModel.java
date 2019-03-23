package com.example.a18314.my_sx2.Model;

import com.example.a18314.my_sx2.Bean.Food;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RequestModel implements InterFaceModel{

    private SuccessModel successModel;

    public RequestModel(SuccessModel successModel){
        this.successModel=successModel;
    }
    @Override
    public void getDataFromRetrofit(Subscriber<Food> subscriber, String Url) {
        Subscription subscribe = NetManager.getNetServer().getData(Url).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).unsubscribeOn(Schedulers.io()).subscribe(subscriber);
    }

    @Override
    public void getResult(String Url) {

        getDataFromRetrofit(new Subscriber<Food>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Food food) {
                successModel.success(food.data);
            }
        },Url);
    }

    public interface SuccessModel{
        void success(Food.data data[]);
    }
}
