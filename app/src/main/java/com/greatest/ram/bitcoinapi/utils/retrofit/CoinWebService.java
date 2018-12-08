package com.greatest.ram.bitcoinapi.utils.retrofit;

import com.greatest.ram.bitcoinapi.utils.model.CryptoModel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface CoinWebService {
//    @GET("/v1/cryptocurrency/listings/latest")
//    Call<ResponseBody> getLatestCoinListing(@Query("convert") String currency);
    @GET("/v1/cryptocurrency/listings/latest")
    Call<CryptoModel> getLatestCoinListing(@Query("convert") String currency);
}
