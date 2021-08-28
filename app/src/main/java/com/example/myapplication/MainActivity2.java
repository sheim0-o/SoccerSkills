package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {

    private TextInputEditText name;
    private TextInputEditText lastName;
    private TextInputEditText email;
    private TextInputEditText password1;
    private TextInputEditText password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = findViewById(R.id.nameRegET);
        lastName = findViewById(R.id.lastNameRegET);
        email = findViewById(R.id.emailRegET);
        password1 = findViewById(R.id.passReg1ET);
        password2 = findViewById(R.id.passReg2ET);
    }

    public void register(View v){
        String nameText = name.getText().toString();
        String lastNameText = lastName.getText().toString();
        String emailText = email.getText().toString();
        String password1Text = password1.getText().toString();
        String password2Text = password2.getText().toString();

        if(nameText.equals("") || lastNameText.equals("") ||
                emailText.equals("") || password1Text.equals("") || password2Text.equals("")) {
            Toast.makeText(this, "Введите данные!",Toast.LENGTH_LONG).show();
        }
        else if (!password1Text.equals(password2Text))
        {
            Toast.makeText(this, "Пароли не совпадают!",Toast.LENGTH_LONG).show();
        }
        else
        {
            Intent intent = new Intent(this, MainActivity.class);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://fspobot.tw1.ru:8080/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            JsonPlaceHolderApi json = retrofit.create(JsonPlaceHolderApi.class);
            API_Registration apiRegistration = new API_Registration(nameText, lastNameText, emailText, password1Text);
            Call<API_Registration> call = json.registration(apiRegistration);

            call.enqueue(new Callback<API_Registration>() {
                @Override
                public void onResponse(Call<API_Registration> call, Response<API_Registration> response) {
                    if(response.isSuccessful())
                    {
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Ошибка " + response.code(),
                                Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<API_Registration> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "t - " + t.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}