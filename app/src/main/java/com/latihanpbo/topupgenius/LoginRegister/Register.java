package com.latihanpbo.topupgenius.LoginRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.latihanpbo.topupgenius.R;

public class Register extends AppCompatActivity {
    Button register;
    EditText usernameET, emailET, passwordET;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        emailET = findViewById(R.id.emailInput);
        usernameET = findViewById(R.id.userInput);
        passwordET = findViewById(R.id.passInput);

        register = findViewById(R.id.register);
        AppDatabase appDatabase = ((MyApplication) getApplication()).getAppDatabase();
        userDao = appDatabase.userDao();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameET.getText().toString();
                String password = passwordET.getText().toString();
                String email = emailET.getText().toString();

                if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Membuat instance userEntity dan mengisi properti
                    userEntity user = new userEntity();
                    user.setUsername(username);
                    user.setPassword(password);
                    user.setEmail(email);

                    // Memanggil metode registerUser dari UserDao
                    userDao.register(user);

                    Toast.makeText(getApplicationContext(), "Akun berhasil dibuat! ", Toast.LENGTH_SHORT).show();
                    Intent loginPage = new Intent(Register.this, Login.class);
                    startActivity(loginPage);
                }
            }
        });
    }
}