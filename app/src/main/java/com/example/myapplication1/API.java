package com.example.myapplication1;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface API {
    @FormUrlEncoded
    @POST("login")
    Call<Login> login(
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("listing")
    Call<ListingList> getlisting(
            @Query("id") int id,
            @Query("token") String token
    );


}
