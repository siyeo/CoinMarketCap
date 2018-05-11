package com.example.tldud.coinmarketcap;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.sql.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//api 요청을 위한 interface
//@Query를 사용하면 &파라메터= 값으로 이어 붙인다
//@path : @GET("movie/{movie_id}" 여기서 {} 값을 넘기기 위해 @Path 사용)

public interface RetrofitService {

    @GET("v2/ticker/")
    Call<JsonObject> getCoinInfo (@Query("limit") int limit);
}
