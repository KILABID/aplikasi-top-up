package com.latihanpbo.topupgenius.Home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.latihanpbo.topupgenius.R;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toolbar toolbar = findViewById(R.id.app_toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Selamat Datang!");
//

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new HomeFragment())
                    .commit();
        }

        //ngirim variable
        String user = getIntent().getStringExtra("username");
        Bundle bundle = new Bundle();

        bundle.putString("username", user);

        AkunFragment akunFragment = new AkunFragment();
        akunFragment.setArguments(bundle);


        bottomNavigationView = findViewById(R.id.navbar);
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.navigation_home) {
                    if (savedInstanceState == null) {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, new HomeFragment())
                                .addToBackStack(null)
                                .commit();
                    }
                    return true;
                } else if (item.getItemId() == R.id.navigation_account) {
                    if (savedInstanceState == null) {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, akunFragment)
                                .commit();
                    }
                    return true;
                }
                return false;
            }
        });



    }
}