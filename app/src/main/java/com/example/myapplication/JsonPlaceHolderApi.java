package com.example.myapplication;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {
    @POST("auth/login")
    Call<API_Login> authorization(@Body API_Login apiLogin);

    @POST("auth/register")
    Call<API_Registration> registration(@Body API_Registration apiRegistration);
}
