package com.example.myapplication1;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference {
    private static SharedPreference Instance;
    private Context context;

    private SharedPreference(Context context) {
        this.context = context;
    }

    public static synchronized SharedPreference getInstance(Context context) {
        if (Instance == null) {
            Instance = new SharedPreference(context);
        }
        return Instance;
    }

        public void user(int id, String token){
            SharedPreferences sharedPreferences= context.getSharedPreferences("loginPrefs", context.MODE_PRIVATE);
            SharedPreferences.Editor editor  = sharedPreferences.edit();

            editor.putInt("id",id);
            editor.putString("token",token);
            editor.apply();

        }

    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("loginPrefs", context.MODE_PRIVATE);
        return sharedPreferences.getInt("id", -1) != -1;
    }

    public String getToken() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("loginPrefs", context.MODE_PRIVATE);
        return sharedPreferences.getString("token", null);
    }

    public int getId() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("loginPrefs", context.MODE_PRIVATE);
        return sharedPreferences.getInt("id", -1);
    }

    public void clear() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("loginPrefs", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }



}
