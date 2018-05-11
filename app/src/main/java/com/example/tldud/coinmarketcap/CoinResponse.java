package com.example.tldud.coinmarketcap;

import com.google.gson.annotations.SerializedName;


import java.util.List;

public class CoinResponse {

    //json의 키값으로 세팅 "coin"

    private List<Coin> coinList;

    public List<Coin> getCoinList() {
        return coinList;
    }
}
