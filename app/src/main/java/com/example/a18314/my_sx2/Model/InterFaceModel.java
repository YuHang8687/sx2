package com.example.a18314.my_sx2.Model;

import com.example.a18314.my_sx2.Bean.Food;

import rx.Subscriber;

public interface InterFaceModel {

    void getDataFromRetrofit(Subscriber<Food> subscriber,String Url);
    void getResult(String Url);
}
