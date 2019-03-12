package com.blogspot.skferdous.justdigitaldiary;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

public class JUSTDigitalDiary extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
