package com.latihanpbo.topupgenius.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.latihanpbo.topupgenius.Komputer.KomputerFragment;
import com.latihanpbo.topupgenius.R;
import com.latihanpbo.topupgenius.Voucher.VoucherFragment;
import com.latihanpbo.topupgenius.Mobile.MobileFragment;

public class ListGame extends AppCompatActivity {
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_game);
        String kategori = getIntent().getStringExtra("kategori");

        backBtn = findViewById(R.id.btnBack);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        if("Mobile".equals(kategori)) {
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameListGame, new MobileFragment())
                        .commit();
            }
        } else if ("Komputer".equals(kategori)) {
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameListGame, new KomputerFragment())
                        .commit();
            }
        } else if("Voucher".equals(kategori)){
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameListGame, new VoucherFragment())
                        .commit();
            }
        }
    }
}