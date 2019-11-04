package com.example.myapplication1;

public class listing {
private int id;
private String listname;
private float distance;

    public listing(int id, String listname, float distance) {
        this.id = id;
        this.listname = listname;
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public String getListname() {
        return listname;
    }

    public float getDistance() {
        return distance;
    }
}
