package com.example.tldud.coinmarketcap;

import com.google.gson.annotations.SerializedName;

public class USD {

    @SerializedName("price")
    private float price;
    @SerializedName("volume_24h")
    private float volume_24h;
    @SerializedName("market_cap")
    private float market_cap;
    @SerializedName("percent_change_1h")
    private float percent_change_1h;
    @SerializedName("percent_change_24h")
    private float percent_change_24h;
    @SerializedName("percent_change_7d")
    private float percent_change_7d;

    public USD() {
        this.price = price;
        this.volume_24h = volume_24h;
        this.market_cap = market_cap;
        this.percent_change_1h = percent_change_1h;
        this.percent_change_24h = percent_change_24h;
        this.percent_change_7d = percent_change_7d;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getVolume_24h() {
        return volume_24h;
    }

    public void setVolume_24h(float volume_24h) {
        this.volume_24h = volume_24h;
    }

    public float getMarket_cap() {
        return market_cap;
    }

    public void setMarket_cap(float market_cap) {
        this.market_cap = market_cap;
    }

    public float getPercent_change_1h() {
        return percent_change_1h;
    }

    public void setPercent_change_1h(float percent_change_1h) {
        this.percent_change_1h = percent_change_1h;
    }

    public float getPercent_change_24h() {
        return percent_change_24h;
    }

    public void setPercent_change_24h(float percent_change_24h) {
        this.percent_change_24h = percent_change_24h;
    }

    public float getPercent_change_7d() {
        return percent_change_7d;
    }

    public void setPercent_change_7d(float percent_change_7d) {
        this.percent_change_7d = percent_change_7d;
    }
}
