package com.greatest.ram.bitcoinapi.utils.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CryptoModel {

    @SerializedName("data")
    public List<Datum> mData;
    @SerializedName("status")
    public Status mStatus;

    public List<Datum> getmData() {
        return mData;
    }

    public void setmData(List<Datum> mData) {
        this.mData = mData;
    }

    public Status getmStatus() {
        return mStatus;
    }

    public void setmStatus(Status mStatus) {
        this.mStatus = mStatus;
    }

    //    public static class Builder {
//
//        private List<Datum> mData;
//        private Status mStatus;
//
//        public CryptoModel.Builder withData(List<Datum> data) {
//            mData = data;
//            return this;
//        }
//
//        public CryptoModel.Builder withStatus(Status status) {
//            mStatus = status;
//            return this;
//        }
//
//        public CryptoModel build() {
//            CryptoModel cryptoModel = new CryptoModel();
//            cryptoModel.mData = mData;
//            cryptoModel.mStatus = mStatus;
//            return cryptoModel;
//        }
//
//    }

}
