package com.latihanpbo.topupgenius;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.latihanpbo.topupgenius.Komputer.TransactionKomputer;
import com.latihanpbo.topupgenius.Mobile.MobileTransaction;
import com.latihanpbo.topupgenius.Voucher.VoucherTransaction;


public class TransactionActivity extends AppCompatActivity {
    ImageView backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        backBtn = findViewById(R.id.btnBack);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        String transaction = getIntent().getStringExtra("transaction");
        if("Valorant".equals(transaction)) {
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameTransaction, new TransactionKomputer())
                        .commit();
            }
        } else if ("Roblox".equals(transaction)) {
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameTransaction, new TransactionKomputer())
                        .commit();
            }
        } else if("Garena Shell".equals(transaction)){
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameTransaction, new TransactionKomputer())
                        .commit();
            }
        }else if("Mobile Legend".equals(transaction)){
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameTransaction, new MobileTransaction())
                        .commit();
            }
        }else if("Free Fire".equals(transaction)){
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameTransaction, new MobileTransaction())
                        .commit();
            }
        }else if("PUBG Mobile".equals(transaction)){
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameTransaction, new MobileTransaction())
                        .commit();
            }
        }else if("Call Of Duty Mobile".equals(transaction)){
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameTransaction, new MobileTransaction())
                        .commit();
            }
        }else if("Steam".equals(transaction)){
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameTransaction, new VoucherTransaction())
                        .commit();
            }
        }else if("Playstation Network".equals(transaction)){
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameTransaction, new VoucherTransaction())
                        .commit();
            }
        }else if("Google Play".equals(transaction)){
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameTransaction, new VoucherTransaction())
                        .commit();
            }
        }else if("Wild Rift".equals(transaction)){
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameTransaction, new MobileTransaction())
                        .commit();
            }
        }
    }
}