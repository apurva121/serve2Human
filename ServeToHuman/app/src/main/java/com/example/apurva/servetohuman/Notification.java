package com.example.apurva.servetohuman;

/**
 * Created by Apurva on 3/17/2018.
 */

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.iid.FirebaseInstanceId;



public class Notification extends FirebaseInstanceIdService{


    @Override
    public void onTokenRefresh() {

        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        //To displaying token on logcat
        Log.d("TOKEN: ", refreshedToken);
    }

}