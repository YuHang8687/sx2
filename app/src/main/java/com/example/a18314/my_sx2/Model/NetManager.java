package com.example.a18314.my_sx2.Model;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetManager {
    public static class CreateRetrofit{
        static Retrofit retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl("http://www.qubaobei.com/")
                .build();
    }
    public static RetrofitServer getNetServer(){
        return CreateRetrofit.retrofit.create(RetrofitServer.class);
    }

}
