package com.latihanpbo.topupgenius.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;

import com.latihanpbo.topupgenius.LoginRegister.Login;
import com.latihanpbo.topupgenius.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        loading();
    }
    public void loading(){
        if(Build.VERSION.SDK_INT > 9){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        final int welcomeScreenDisplay = 5000;
        Thread welcomeThread = new Thread(){
            int wait = 0;

            @Override
            public void run() {
                try {
                    super.run();
                    while (wait < welcomeScreenDisplay) {
                        sleep(100);
                        wait += 100;

                    }
                }catch (Exception e){
                    System.out.println("EXc=" + e);
                } finally {
                    Intent intent = new Intent(SplashScreen.this, Login.class);
                    finish();
                    startActivity(intent);
                }
            }
        };
        welcomeThread.start();
    }
}