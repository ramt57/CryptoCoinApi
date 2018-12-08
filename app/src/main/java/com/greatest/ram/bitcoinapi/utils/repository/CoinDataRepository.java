package com.greatest.ram.bitcoinapi.utils.repository;

import android.util.Log;
import android.widget.Toast;
import androidx.lifecycle.LiveData;
import com.greatest.ram.bitcoinapi.utils.model.CryptoModel;
import com.greatest.ram.bitcoinapi.utils.model.Datum;
import com.greatest.ram.bitcoinapi.utils.retrofit.CoinWebService;
import com.greatest.ram.bitcoinapi.utils.room.dao.DatumDoa;
import com.greatest.ram.bitcoinapi.utils.utils.Constant;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.inject.Singleton;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;

@Singleton
public class CoinDataRepository {
    private final CoinWebService coinWebService;
    private final DatumDoa datumDoa;
    private final Executor executor;

    public CoinDataRepository(CoinWebService coinWebService, DatumDoa datumDoa, Executor executor) {
        this.coinWebService = coinWebService;
        this.datumDoa = datumDoa;
        this.executor = executor;
        refreshData();
    }
    // return a LiveData directly from the database.

    public LiveData<List<Datum>> getAllCoinData() {
        return datumDoa.loadAll();
    }
    public LiveData<Datum> getCoinData(long id){
        return  datumDoa.load(id);
    }

    private void refreshData() {
        executor.execute(() -> {
            // Check if data was fetched recently or not
            boolean userExists = (datumDoa.getCoin(getMaxRefreshTime(new Date())) != null);
            // If data have to be updated
            if (!userExists) {
                callnetwork();
            }
        });
    }
    /*call api only when necessary*/
    private void callnetwork() {
        coinWebService.getLatestCoinListing("USD,INR").enqueue(new Callback<CryptoModel>() {
            @Override
            public void onResponse(Call<CryptoModel> call, Response<CryptoModel> response) {

                    Log.w("TAG", "Data refreshed from network !" + response.body());

                            executor.execute(() -> {
                                List<Datum> datumlist=response.body().mData;
                                for (Datum datum:datumlist){
                                    datum.setLastRefresh(new Date());
                                    datumDoa.save(datum);
                                }
                            });
            }

            @Override
            public void onFailure(Call<CryptoModel> call, Throwable t) {
                Log.w("TAG", "fail" + t.toString());
            }
        });
    }

    private Date getMaxRefreshTime(Date currentDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.MINUTE, -Constant.REFRESH_MINUTE);
        return cal.getTime();
    }
}
