package com.greatest.ram.bitcoinapi.utils.activity;

import android.content.IntentFilter;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.greatest.ram.bitcoinapi.utils.R;
import com.greatest.ram.bitcoinapi.utils.adapters.RecyclerAdapter;
import com.greatest.ram.bitcoinapi.utils.model.Datum;
import com.greatest.ram.bitcoinapi.utils.reciever.ConnectivityChange;
import com.greatest.ram.bitcoinapi.utils.viewmodels.viewmodel.CoinViewModel;
import dagger.android.AndroidInjection;


import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private CoinViewModel viewModel;
    List<Datum> list = new ArrayList<>();
    ConnectivityChange connectivityChange;
    RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerAdapter = new RecyclerAdapter(list);
        recyclerView.setAdapter(recyclerAdapter);
        connectivityChange = ConnectivityChange.getINSTANCE();
        registerReceiver(connectivityChange, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        configureDagger();
        configureViewModel();
    }

    private void configureDagger() {
        AndroidInjection.inject(this);
    }

    private void configureViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(CoinViewModel.class);
        viewModel.initlistAll();
        viewModel.getDatumList().observe(this, this::updateUI);
    }

    private void updateUI(List<Datum> datumlist) {
        if (datumlist != null)
            for (Datum datum : datumlist) {
                list.add(datum);
                Log.w("ACTIVITY", datum.getmName() + datum.getmId());
            }
        recyclerAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(connectivityChange);
    }
}
