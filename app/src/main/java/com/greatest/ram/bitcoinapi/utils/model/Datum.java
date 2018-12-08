package com.greatest.ram.bitcoinapi.utils.model;

import java.util.Date;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;

@Entity
public class Datum {

    @PrimaryKey
    @SerializedName("id")
    public Long mId;
    @SerializedName("circulating_supply")
    public Double mCirculatingSupply;
    @SerializedName("cmc_rank")
    public Double mCmcRank;
    @SerializedName("date_added")
    public String mDateAdded;

    @SerializedName("last_updated")
    public String mLastUpdated;
    @SerializedName("max_supply")
    public Double mMaxSupply;
    @SerializedName("name")
    public String mName;
    @SerializedName("num_market_pairs")
    public Double mNumMarketPairs;
    @Embedded
    @SerializedName("platform")
    public Platform mPlatform;
    @Embedded
    @SerializedName("quote")
    public Quote mQuote;
    @SerializedName("slug")
    public String mSlug;
    @SerializedName("symbol")
    public String mSymbol;
    @Ignore
    @SerializedName("tags")
    public List<String> mTags;
    @SerializedName("total_supply")
    public Double mTotalSupply;

    public Date lastRefresh;

    public Datum() {
    }

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public Double getmCirculatingSupply() {
        return mCirculatingSupply;
    }

    public void setmCirculatingSupply(Double mCirculatingSupply) {
        this.mCirculatingSupply = mCirculatingSupply;
    }

    public Double getmCmcRank() {
        return mCmcRank;
    }

    public void setmCmcRank(Double mCmcRank) {
        this.mCmcRank = mCmcRank;
    }

    public String getmDateAdded() {
        return mDateAdded;
    }

    public void setmDateAdded(String mDateAdded) {
        this.mDateAdded = mDateAdded;
    }

    public String getmLastUpdated() {
        return mLastUpdated;
    }

    public void setmLastUpdated(String mLastUpdated) {
        this.mLastUpdated = mLastUpdated;
    }

    public Double getmMaxSupply() {
        return mMaxSupply;
    }

    public void setmMaxSupply(Double mMaxSupply) {
        this.mMaxSupply = mMaxSupply;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public Double getmNumMarketPairs() {
        return mNumMarketPairs;
    }

    public void setmNumMarketPairs(Double mNumMarketPairs) {
        this.mNumMarketPairs = mNumMarketPairs;
    }

    public Platform getmPlatform() {
        return mPlatform;
    }

    public void setmPlatform(Platform mPlatform) {
        this.mPlatform = mPlatform;
    }

    public Quote getmQuote() {
        return mQuote;
    }

    public void setmQuote(Quote mQuote) {
        this.mQuote = mQuote;
    }

    public String getmSlug() {
        return mSlug;
    }

    public void setmSlug(String mSlug) {
        this.mSlug = mSlug;
    }

    public String getmSymbol() {
        return mSymbol;
    }

    public void setmSymbol(String mSymbol) {
        this.mSymbol = mSymbol;
    }

    public List<String> getmTags() {
        return mTags;
    }

    public void setmTags(List<String> mTags) {
        this.mTags = mTags;
    }

    public Double getmTotalSupply() {
        return mTotalSupply;
    }

    public void setmTotalSupply(Double mTotalSupply) {
        this.mTotalSupply = mTotalSupply;
    }

    public Date getLastRefresh() {
        return lastRefresh;
    }

    public void setLastRefresh(Date lastRefresh) {
        this.lastRefresh = lastRefresh;
    }
}
