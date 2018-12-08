package com.greatest.ram.bitcoinapi.utils.model;

import com.google.gson.annotations.SerializedName;

public class Platform {
    @SerializedName("id")
    long id;
    @SerializedName("name")
    String name;
    @SerializedName("symbol")
    String symbol;
    @SerializedName("slug")
    String slug;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
