package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private EditText login;
    private EditText email;
    private EditText password1;
    private EditText password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        login = (EditText) findViewById(R.id.loginSignup);
        email = (EditText) findViewById(R.id.email);
        password1 = (EditText) findViewById(R.id.password1Signup);
        password2 = (EditText) findViewById(R.id.password2Signup);
    }

    public void register(View v){
        if(login.getText().toString().equals("") || email.getText().toString().equals("")
        || password1.getText().toString().equals("") || password2.getText().toString().equals("")) {
            Toast toast = Toast.makeText(this, "Введите данные!",Toast.LENGTH_LONG);
            toast.show();
        }
        else
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}