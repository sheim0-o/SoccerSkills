package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    private TextView email;
    private TextView password;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        email = (TextView) findViewById(R.id.loginTxt);
        password = (TextView) findViewById(R.id.passwordTxt);

        String txtEmail = getIntent().getStringExtra("email");
        String txtPassword = getIntent().getStringExtra("password");

        email.setText(getText(R.string.text_YourLogin) + " " + txtEmail);
        password.setText(getText(R.string.text_YourPasssword) + " " + txtPassword);
    }
}