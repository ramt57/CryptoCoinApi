
package com.greatest.ram.bitcoinapi.utils.model;

import androidx.room.Ignore;
import com.google.gson.annotations.SerializedName;


public class USD {
    @SerializedName("last_updated")
    public String mLastUpdatedUSD;
    @SerializedName("market_cap")
    public Double mMarketCap;
    @SerializedName("percent_change_1h")
    public Double mPercentChange1H;
    @SerializedName("percent_change_24h")
    public Double mPercentChange24H;
    @SerializedName("percent_change_7d")
    public Double mPercentChange7D;
    @SerializedName("price")
    public Double mPrice;
    @SerializedName("volume_24h")
    public Double mVolume24H;

    public USD() {

    }

    public String getLastUpdated() {
        return mLastUpdatedUSD;
    }

    public Double getMarketCap() {
        return mMarketCap;
    }

    public Double getPercentChange1H() {
        return mPercentChange1H;
    }

    public Double getPercentChange24H() {
        return mPercentChange24H;
    }

    public Double getPercentChange7D() {
        return mPercentChange7D;
    }

    public Double getPrice() {
        return mPrice;
    }

    public Double getVolume24H() {
        return mVolume24H;
    }



}
