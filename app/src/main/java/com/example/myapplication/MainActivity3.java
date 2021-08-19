package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    private TextView login;
    private TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        login = (TextView) findViewById(R.id.loginTxt);
        password = (TextView) findViewById(R.id.passwordTxt);

        String txtLogin = getIntent().getStringExtra("login");
        String txtPassword = getIntent().getStringExtra("password");

        login.setText(getText(R.string.text_YourLogin) + " " + txtLogin);
        password.setText(getText(R.string.text_YourPasssword) + " " + txtPassword);
    }
}