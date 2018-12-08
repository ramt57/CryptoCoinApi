
package com.greatest.ram.bitcoinapi.utils.model;

import androidx.room.Embedded;
import com.google.gson.annotations.SerializedName;

public class Quote {
    @Embedded
    @SerializedName("USD")
    public USD mUSD;
    @Embedded
    @SerializedName("INR")
    public INR mINR;
    public USD getmUSD() {
        return mUSD;
    }

    public void setmUSD(USD mUSD) {
        this.mUSD = mUSD;
    }

    public INR getmINR() {
        return mINR;
    }

    public void setmINR(INR mINR) {
        this.mINR = mINR;
    }
//    public static class Builder {
//
//        private USD mUSD;
//
//        public Quote.Builder withUSD(USD uSD) {
//            mUSD = uSD;
//            return this;
//        }
//
//        public Quote build() {
//            Quote quote = new Quote();
//            quote.mUSD = mUSD;
//            return quote;
//        }
//
//    }

}
