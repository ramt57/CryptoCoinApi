package com.greatest.ram.bitcoinapi.utils.activity;

import android.content.IntentFilter;
import android.graphics.PorterDuff;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.greatest.ram.bitcoinapi.utils.R;
import com.greatest.ram.bitcoinapi.utils.model.Datum;
import com.greatest.ram.bitcoinapi.utils.reciever.ConnectivityChange;
import com.greatest.ram.bitcoinapi.utils.viewmodels.viewmodel.CoinViewModel;
import dagger.android.AndroidInjection;

import javax.inject.Inject;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private CoinViewModel viewModel;
    TextView symbol, name, rank, usd, inr, priceone, priceseven, priceday;
    ImageView arrowone, arrowseven, arrowday;
    ConnectivityChange connectivityChange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        connectivityChange = ConnectivityChange.getINSTANCE();
        configureDagger();
        configureViewModel();
        initview();
        registerReceiver(connectivityChange, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));

    }

    private void initview() {
        symbol = findViewById(R.id.symbol);
        name = findViewById(R.id.name);
        rank = findViewById(R.id.rank);
        usd = findViewById(R.id.priceusd);
        inr = findViewById(R.id.priceinr);
        priceone = findViewById(R.id.priceone);
        priceseven = findViewById(R.id.priceseven);
        priceday = findViewById(R.id.priceday);
        arrowone = findViewById(R.id.symbolone);
        arrowday = findViewById(R.id.symbolday);
        arrowseven = findViewById(R.id.symbolseven);
    }

    private void configureDagger() {
        AndroidInjection.inject(this);
    }

    private void configureViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(CoinViewModel.class);
        viewModel.initdata(getIntent().getLongExtra("ID", -1));
        viewModel.getDatum().observe(this, this::updateUI);
    }

    private void updateUI(Datum datum) {
        if (datum != null) {
            symbol.setText(datum.getmSymbol() + "");
            name.setText(datum.getmName() + "");
            rank.setText("RANK "+datum.getmCmcRank());
            usd.setText(datum.getmQuote().getmUSD().getPrice() + "");
            inr.setText(datum.getmQuote().getmINR().getmPriceINR() + "");
            if (datum.getmQuote().getmINR().getmPercentChange1HINR() < 0) {
                /*red*/
                arrowone.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
            } else {
                /*green*/
                arrowone.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
            }
            if (datum.getmQuote().getmINR().getmPercentChange24HINR() < 0) {
                /*red*/
                arrowday.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
            } else {
                /*green*/
                arrowday.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
            }
            if (datum.getmQuote().getmINR().getmPercentChange7DINR() < 0) {
                /*red*/
                arrowseven.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
            } else {
                /*green*/
                arrowseven.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
            }
            priceone.setText(datum.getmQuote().getmINR().getmPercentChange1HINR() + "");
            priceday.setText(datum.getmQuote().getmINR().getmPercentChange24HINR() + "");
            priceseven.setText(datum.getmQuote().getmINR().getmPercentChange7DINR() + "");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(connectivityChange);
    }
}
