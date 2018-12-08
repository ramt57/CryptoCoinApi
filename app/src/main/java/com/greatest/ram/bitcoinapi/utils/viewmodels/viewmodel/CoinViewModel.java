package com.greatest.ram.bitcoinapi.utils.viewmodels.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.greatest.ram.bitcoinapi.utils.model.Datum;
import com.greatest.ram.bitcoinapi.utils.repository.CoinDataRepository;

import javax.inject.Inject;
import java.util.List;

public class CoinViewModel extends ViewModel {
    private LiveData<List<Datum>> datumlistLiveData;
    private LiveData<Datum> datumLiveData;
    private CoinDataRepository coinRepo;

    @Inject
    public CoinViewModel(CoinDataRepository coinRepo) {
        this.coinRepo = coinRepo;
    }

    public void initlistAll() {
        if (this.datumlistLiveData != null) {
            return;
        }
        datumlistLiveData = coinRepo.getAllCoinData();

    }
    public void initdata(long id) {
        if (this.datumLiveData != null) {
            return;
        }
        datumLiveData = coinRepo.getCoinData(id);

    }
    public LiveData<List<Datum>> getDatumList() {
        return this.datumlistLiveData;
    }
    public LiveData<Datum> getDatum(){
        return this.datumLiveData;
    }


}
