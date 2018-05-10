package com.example.tldud.coinmarketcap;

import com.google.gson.annotations.SerializedName;

public class Quotes {

    @SerializedName("USD")
    public USD usd;


    public Quotes(USD usd) {
        this.usd = usd;
    }



    public USD getUsd() {
        return usd;
    }

    public void setUsd(USD usd) {
        this.usd = usd;
    }
}
