package com.greatest.ram.bitcoinapi.utils.di.modules;

import com.greatest.ram.bitcoinapi.utils.activity.DetailActivity;
import com.greatest.ram.bitcoinapi.utils.activity.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();
    @ContributesAndroidInjector
    abstract DetailActivity contributeDetailActivity();
}