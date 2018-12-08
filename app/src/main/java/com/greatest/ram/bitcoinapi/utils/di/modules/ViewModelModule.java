package com.greatest.ram.bitcoinapi.utils.di.modules;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.greatest.ram.bitcoinapi.utils.di.key.ViewModelKey;
import com.greatest.ram.bitcoinapi.utils.viewmodels.ViewModelFactory;
import com.greatest.ram.bitcoinapi.utils.viewmodels.viewmodel.CoinViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CoinViewModel.class)
    abstract ViewModel bindCoinViewModel(CoinViewModel repoViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}