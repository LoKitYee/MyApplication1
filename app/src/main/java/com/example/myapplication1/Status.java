package com.example.myapplication1;

import com.google.gson.annotations.SerializedName;

public class Status {

    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;

    public Status(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
