package com.example.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListingActivity extends AppCompatActivity {
    private String token = "";
    private RecyclerView RecycleListing;
    private RecyclerView.Adapter adapter;
    private Button btnLogout;
    private int id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listing_recycler);

        if (SharedPreference.getInstance(this).getToken() != null) {
            token = SharedPreference.getInstance(this).getToken();
            id = SharedPreference.getInstance(this).getId();
        }

        this.RecycleListing = (RecyclerView) findViewById(R.id.recyclerViewListing);
        btnLogout = (Button) findViewById(R.id.buttonlogout);

        RecyclerView.LayoutManager LayoutManager = new LinearLayoutManager(this);
        this.RecycleListing.setLayoutManager(LayoutManager);


        Call<ListingList> call =Retrofit.getInstance().getAPI().getlisting(id,token.trim());
        call.enqueue(new Callback<ListingList>() {
            @Override
            public void onResponse(Call<ListingList> call, Response<ListingList> response) {
                try {
                    ListingList listing = response.body();
                    RecyclerView(listing.getListing());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ListingList> call, Throwable t) {
                Log.d("TAG", "Invalid token");
                t.printStackTrace();
            }

        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        SharedPreference.getInstance(ListingActivity.this).clear();
                        Toast.makeText(ListingActivity.this, "Logout successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ListingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void RecyclerView(ArrayList<listing> listing) {
        adapter=new listingAdapter(listing);
        RecycleListing.setAdapter(adapter);
    }



}