package com.example.a18314.my_sx2.Model;

import com.example.a18314.my_sx2.Bean.Food;

import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

public interface RetrofitServer {
    @GET
    Observable<Food> getData(@Url String url);
}
