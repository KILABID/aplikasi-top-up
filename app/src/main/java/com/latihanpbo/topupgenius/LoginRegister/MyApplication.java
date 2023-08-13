package com.latihanpbo.topupgenius.LoginRegister;

import android.app.Application;

import androidx.room.Room;

public class MyApplication extends Application {
    private AppDatabase appDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        appDatabase = Room.databaseBuilder(this, AppDatabase.class, "topupgenius").allowMainThreadQueries()
                .build();
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
