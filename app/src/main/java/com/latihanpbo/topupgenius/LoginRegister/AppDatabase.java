package com.latihanpbo.topupgenius.LoginRegister;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {userEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
}

