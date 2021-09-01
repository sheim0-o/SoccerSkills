package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText email;
    private TextInputEditText password;

    private static final String MY_SETTINGS = "my_settings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = getSharedPreferences(MY_SETTINGS, Context.MODE_PRIVATE);
        boolean hasVisited = sp.getBoolean("hasVisited", false);
        if(!hasVisited){
            startActivity(new Intent(this, MainActivity4.class));

            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean("hasVisited", true);
            editor.apply();
        }
        email = findViewById(R.id.emailLogET);
        password = findViewById(R.id.passLogET);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSignup:
                Intent intent1 = new Intent(this, MainActivity2.class);
                startActivity(intent1);
                break;
            case R.id.btnSignin:
                Intent intent2 = new Intent(this, MainActivity3.class);

                MaterialAlertDialogBuilder alertDialog1 = new MaterialAlertDialogBuilder(this)
                        .setTitle("Ошибка!");

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://fspobot.tw1.ru:8080/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                JsonPlaceHolderApi json = retrofit.create(JsonPlaceHolderApi.class);
                API_Login apiLogin = new API_Login(email.getText().toString(), password.getText().toString());
                Call<API_Login> call = json.authorization(apiLogin);

                call.enqueue(new Callback<API_Login>() {
                    @Override
                    public void onResponse(Call<API_Login> call, Response<API_Login> response) {
                        if(response.isSuccessful())
                        {
                                intent2.putExtra("email", email.getText().toString());
                                intent2.putExtra("password", password.getText().toString());
                                startActivity(intent2);
                        }
                        else if (response.code() == 401)
                        {
                            alertDialog1.setMessage("Неверно введены данные!").show();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Ошибка " + response.code(),
                                    Toast.LENGTH_SHORT).show();
                            alertDialog1.setMessage("Ошибка №" + response.code()).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<API_Login> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "t - " + t.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            default:
                break;
        }
    }
}