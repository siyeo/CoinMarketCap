package com.example.tldud.coinmarketcap;


import com.google.gson.annotations.SerializedName;

public class Coin {

    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("symbol")
    private String symbol;
    @SerializedName("website_slug")
    private String websiteSlug;
    @SerializedName("rank")
    private Integer rank;
    @SerializedName("circulating_supply")
    private float circulation_supply;
    @SerializedName("total_supply")
    private float total_supply;
    @SerializedName("max_supply")
    private float max_supply;
    @SerializedName("quotes")
    public Quotes quotes;
    @SerializedName("last_updated")
    private Integer last_updated;

    public Coin(Integer id, String name, String symbol, String websiteSlug, Integer rank, float circulation_supply, float total_supply, float max_supply,Quotes quotes, Integer last_updated) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.websiteSlug = websiteSlug;
        this.rank = rank;
        this.circulation_supply = circulation_supply;
        this.total_supply = total_supply;
        this.max_supply = max_supply;
        this.quotes = quotes;
        this.last_updated = last_updated;
    }

    public Integer getId() {
        if(id == null){
            return 0;
        }
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getWebsiteSlug() {
        return websiteSlug;
    }

    public void setWebsiteSlug(String websiteSlug) {
        this.websiteSlug = websiteSlug;
    }

    public Integer getRank() {
        if(rank == null){
            return 0;
        }
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public float getCirculation_supply() {
        return circulation_supply;
    }

    public void setCirculation_supply(float circulation_supply) {
        this.circulation_supply = circulation_supply;
    }

    public float getTotal_supply() {
        return total_supply;
    }

    public void setTotal_supply(float total_supply) {
        this.total_supply = total_supply;
    }

    public float getMax_supply() {
        return max_supply;
    }

    public void setMax_supply(float max_supply) {
        this.max_supply = max_supply;
    }

    public Quotes getQuotes() {
        return quotes;
    }

    public void setQuotes(Quotes quotes) {
        this.quotes = quotes;
    }

    public Integer getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(Integer last_updated) {
        this.last_updated = last_updated;
    }
}


