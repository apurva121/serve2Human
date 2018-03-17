package com.example.apurva.servetohuman;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Apurva on 3/18/2018.
 */

@IgnoreExtraProperties
public class FCM_Device_Tokens {


    private String token;

    public FCM_Device_Tokens() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}