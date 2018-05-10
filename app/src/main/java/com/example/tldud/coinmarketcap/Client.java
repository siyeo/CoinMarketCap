package com.example.tldud.coinmarketcap;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//retrofit 인스턴스를 생성하기 위한 client 클래스

public class Client {

    public static final String root_URL = " https://api.coinmarketcap.com";
    public static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(root_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
