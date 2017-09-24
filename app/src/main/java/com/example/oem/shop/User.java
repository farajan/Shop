package com.example.oem.shop;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by OEM on 18.9.2017.
 */

@IgnoreExtraProperties
public class User {

    public String email;
    public String photoURL;

    public User() {

    }

    public User(String email, String photoURL) {
        this.email = email;
        this.photoURL = photoURL;
    }

    @Override
    public String toString() {
        return "User{" +
                ", email='" + email + '\'' +
                ", photoURL='" + photoURL + '\'' +
                '}';
    }
}
