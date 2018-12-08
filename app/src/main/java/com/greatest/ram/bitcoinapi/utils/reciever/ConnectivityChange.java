package com.greatest.ram.bitcoinapi.utils.reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.greatest.ram.bitcoinapi.utils.utils.NetworkUtils;

public  class ConnectivityChange extends BroadcastReceiver {
    private static volatile ConnectivityChange INSTANCE;
    private static boolean status =true;
    public static synchronized ConnectivityChange getINSTANCE(){
        if(INSTANCE==null){
            INSTANCE=new ConnectivityChange();
        }
        return INSTANCE;
    }
    private ConnectivityChange(){

    }
    @Override
    public void onReceive(Context context, Intent intent) {
        status=NetworkUtils.getActiveNetworkInfo();
        if(!status)
            NetworkUtils.showAlert(context);
    }


}
