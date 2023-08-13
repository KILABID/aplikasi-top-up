package com.latihanpbo.topupgenius.LoginRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.latihanpbo.topupgenius.R;
import com.latihanpbo.topupgenius.Home.MainActivity;

public class Login extends AppCompatActivity {
    Button btnLogin;
    EditText username, password;
    TextView register;
    String usernameString, passwordString;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.usernameInput);
        password = findViewById(R.id.passwordInput);

        btnLogin = findViewById(R.id.btnLogin);
        AppDatabase appDatabase = ((MyApplication) getApplication()).getAppDatabase();
        userDao = appDatabase.userDao();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usernameString = username.getText().toString();
                passwordString = password.getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        userEntity user = userDao.login(usernameString, passwordString);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (user != null) {
                                    Intent mainActivity = new Intent(Login.this, MainActivity.class);
                                    mainActivity.putExtra("username", usernameString);
                                    finish();
                                    startActivity(mainActivity);
                                } else {
                                    Toast.makeText(Login.this, "Username dan Password yang Anda masukkan salah!!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }).start();
            }
        });

        register = findViewById(R.id.btnRegister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerActivity = new Intent(Login.this, Register.class);
                startActivity(registerActivity);
            }
        });
    }
}