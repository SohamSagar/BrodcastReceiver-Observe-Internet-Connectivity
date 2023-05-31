package com.example.brodcastreceiver_observe_internet_connectivity

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.brodcastreceiver_observe_internet_connectivity.receiver.NetworkStateChangeListener

class MainActivity : AppCompatActivity() {
    var receiver: NetworkStateChangeListener? = null
    var intentFilter: IntentFilter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        intentFilter = IntentFilter()
        intentFilter!!.addAction("$packageName.android.net.conn.CONNECTIVITY_CHANGE")
        Log.e("sagar",packageName + "android.net.conn.CONNECTIVITY_CHANGE")
        registerReceiver(NetworkStateChangeListener(), filter)
    }

    override fun onPause() {
        unregisterReceiver(receiver)
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(receiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }
}