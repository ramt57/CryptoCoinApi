package com.greatest.ram.bitcoinapi.utils.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.greatest.ram.bitcoinapi.utils.App;

public class NetworkUtils {
    public static boolean getActiveNetworkInfo(){
        ConnectivityManager cm =
                (ConnectivityManager) App.context.getSystemService(Context.CONNECTIVITY_SERVICE);

        assert cm != null;
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }
    public  static void showAlert(Context ctx){
        new AlertDialog.Builder(ctx)
                .setTitle("Connection Disconnected")
                .setMessage("No Internet Connection.")
                .setPositiveButton("Dismiss", (dialog, which) -> dialog.dismiss())
                .show();
    }
}
