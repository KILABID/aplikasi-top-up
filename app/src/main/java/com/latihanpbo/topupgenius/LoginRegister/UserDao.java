package com.latihanpbo.topupgenius.LoginRegister;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM users WHERE username = :username AND password = :password")
    userEntity login(String username, String password);

    @Insert
    void register(userEntity user);
}
