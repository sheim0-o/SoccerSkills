package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText login;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.psswrd);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSignup:
                Intent intent1 = new Intent(this, MainActivity2.class);
                startActivity(intent1);
                break;
            case R.id.btnSignin:
                Intent intent2 = new Intent(this, MainActivity3.class);

                intent2.putExtra("login", login.getText().toString());
                intent2.putExtra("password", password.getText().toString());

                startActivity(intent2);
                break;
            default:
                break;
        }
    }
}