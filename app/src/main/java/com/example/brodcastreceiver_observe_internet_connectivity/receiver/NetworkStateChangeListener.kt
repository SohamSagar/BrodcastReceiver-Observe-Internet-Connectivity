package com.example.brodcastreceiver_observe_internet_connectivity.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.brodcastreceiver_observe_internet_connectivity.utils.AppUtils

class NetworkStateChangeListener : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.e("state","working")
        if(AppUtils.isNetworkAvailable(context!!))
            AppUtils.toastMessage("You Are Online !",context)
        else
            AppUtils.toastMessage("You Are Offline !",context)
    }
}