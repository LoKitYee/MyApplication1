package com.example.myapplication1;

import java.util.ArrayList;

public class ListingList {
    private ArrayList<listing> listing;
    private Status status;

    public ListingList(ArrayList<listing> listing, Status status){
        this.listing = listing;
        this.status=status;
    }

    public ArrayList<listing> getListing() {
        return listing;
    }

    public void setListing(ArrayList<listing> listing) {
        this.listing = listing;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
