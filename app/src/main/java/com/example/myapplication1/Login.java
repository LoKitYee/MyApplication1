package com.example.myapplication1;

import com.google.gson.annotations.SerializedName;

public class Login {

    @SerializedName("id")
    private int id;
    @SerializedName("token")
    private String token;
    @SerializedName("status")
    private Status status;

    public Login(int id, String token, Status status) {
        this.id = id;
        this.token = token.trim();
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
