package com.example.apurva.servetohuman;

/**
 * Created by Apurva on 3/17/2018.
 */

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.iid.FirebaseInstanceId;



public class Notification extends FirebaseInstanceIdService{


    @Override
    public void onTokenRefresh() {

        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        //To displaying token on logcat
        Log.d("TOKEN: ", refreshedToken);
    }

    private void sendRegistrationToServer(final String token) {
        // Add custom implementation, as needed.

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference fcmDatabaseRef = mDatabase.child("FCM_Device_Tokens").push();

        FCM_Device_Tokens obj = new FCM_Device_Tokens();
        obj.setToken(token);
        fcmDatabaseRef.setValue(obj);
    }

}