package com.example.tldud.coinmarketcap;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CoinResponse {

    //json의 키값으로 세팅 "coin"

    @SerializedName("Coin")
    private ArrayList<Coin> coinArrayList;

    public ArrayList<Coin> getCoinArrayList() {
        return coinArrayList;
    }
}
