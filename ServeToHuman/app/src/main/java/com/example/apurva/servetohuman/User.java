package com.example.apurva.servetohuman;

/**
 * Created by Apurva on 3/17/2018.
 */

public class User {
    String UserId;
    String message;
    String contact;
    String location;



    public User(String USerId, String message, String contact, String location){
        this.UserId = USerId;

        this.message = message;
        this.contact = contact;
        this.location = location;
    }
    public String getUserId() {
        return UserId;
    }

    public String getMessage() {
        return message;
    }

    public String getContact() {
        return contact;
    }

    public String getLocation() {
        return location;
    }
}
