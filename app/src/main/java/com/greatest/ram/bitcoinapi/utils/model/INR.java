package com.greatest.ram.bitcoinapi.utils.model;

import com.google.gson.annotations.SerializedName;

public class INR {
    @SerializedName("last_updated")
    public String mLastUpdatedINR;
    @SerializedName("market_cap")
    public Double mMarketCapINR;
    @SerializedName("percent_change_1h")
    public Double mPercentChange1HINR;
    @SerializedName("percent_change_24h")
    public Double mPercentChange24HINR;
    @SerializedName("percent_change_7d")
    public Double mPercentChange7DINR;
    @SerializedName("price")
    public Double mPriceINR;
    @SerializedName("volume_24h")
    public Double mVolume24HINR;

    public INR() {
    }

    public String getmLastUpdatedINR() {
        return mLastUpdatedINR;
    }

    public void setmLastUpdatedINR(String mLastUpdatedINR) {
        this.mLastUpdatedINR = mLastUpdatedINR;
    }

    public Double getmMarketCapINR() {
        return mMarketCapINR;
    }

    public void setmMarketCapINR(Double mMarketCapINR) {
        this.mMarketCapINR = mMarketCapINR;
    }

    public Double getmPercentChange1HINR() {
        return mPercentChange1HINR;
    }

    public void setmPercentChange1HINR(Double mPercentChange1HINR) {
        this.mPercentChange1HINR = mPercentChange1HINR;
    }

    public Double getmPercentChange24HINR() {
        return mPercentChange24HINR;
    }

    public void setmPercentChange24HINR(Double mPercentChange24HINR) {
        this.mPercentChange24HINR = mPercentChange24HINR;
    }

    public Double getmPercentChange7DINR() {
        return mPercentChange7DINR;
    }

    public void setmPercentChange7DINR(Double mPercentChange7DINR) {
        this.mPercentChange7DINR = mPercentChange7DINR;
    }

    public Double getmPriceINR() {
        return mPriceINR;
    }

    public void setmPriceINR(Double mPriceINR) {
        this.mPriceINR = mPriceINR;
    }

    public Double getmVolume24HINR() {
        return mVolume24HINR;
    }

    public void setmVolume24HINR(Double mVolume24HINR) {
        this.mVolume24HINR = mVolume24HINR;
    }
}
