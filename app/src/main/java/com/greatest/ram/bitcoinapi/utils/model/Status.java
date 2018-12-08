
package com.greatest.ram.bitcoinapi.utils.model;

import com.google.gson.annotations.SerializedName;

public class Status {

    @SerializedName("credit_count")
    public Double mCreditCount;
    @SerializedName("elapsed")
    public Double mElapsed;
    @SerializedName("error_code")
    public Double mErrorCode;
    @SerializedName("error_message")
    public Object mErrorMessage;
    @SerializedName("timestamp")
    public String mTimestamp;

    public Double getmCreditCount() {
        return mCreditCount;
    }

    public void setmCreditCount(Double mCreditCount) {
        this.mCreditCount = mCreditCount;
    }

    public Double getmElapsed() {
        return mElapsed;
    }

    public void setmElapsed(Double mElapsed) {
        this.mElapsed = mElapsed;
    }

    public Double getmErrorCode() {
        return mErrorCode;
    }

    public void setmErrorCode(Double mErrorCode) {
        this.mErrorCode = mErrorCode;
    }

    public Object getmErrorMessage() {
        return mErrorMessage;
    }

    public void setmErrorMessage(Object mErrorMessage) {
        this.mErrorMessage = mErrorMessage;
    }

    public String getmTimestamp() {
        return mTimestamp;
    }

    public void setmTimestamp(String mTimestamp) {
        this.mTimestamp = mTimestamp;
    }
}
