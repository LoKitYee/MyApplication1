package com.example.myapplication1;

import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit {

    private static retrofit2.Retrofit retrofit;
    private static Retrofit Instance;


    private Retrofit() {
        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl("http://interview.advisoryapps.com/index.php/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static synchronized Retrofit getInstance() {
        if (Instance == null) Instance = new Retrofit();
        return Instance;
    }

    public static API getAPI(){return retrofit.create(API.class);}
}
