package com.example.tldud.coinmarketcap;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//retrofit 인스턴스를 생성하기 위한 client 클래스

public class Client {

    public static final String root_URL = " http://api.coinmarketcap.com";
    public static Retrofit retrofit = null;

    // Logging
    static HeaderInterceptor mHeaderInterceptor = new HeaderInterceptor();
    static HttpLoggingInterceptor logging = getHttpLoggingInterceptorClient();


    public static Retrofit getRetrofit() {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(root_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static class HeaderInterceptor
            implements Interceptor {
        @Override
        public Response intercept(Chain chain)
                throws IOException {
            Request request = chain.request();
            request = request.newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "application/json")
                    .build();
            Response response = chain.proceed(request);
            return response;
        }
    }

    public static HttpLoggingInterceptor getHttpLoggingInterceptorClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return logging;
    }
}
