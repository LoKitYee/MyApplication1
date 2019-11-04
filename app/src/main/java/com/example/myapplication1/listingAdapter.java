package com.example.myapplication1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class listingAdapter extends RecyclerView.Adapter<listingAdapter.ViewHolder> {
    private Context context;
    private ArrayList<listing> listing;
    private ItemClickListener mClickListener;

    public listingAdapter(ArrayList<listing> listing ){this.listing = listing;}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listing_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull listingAdapter.ViewHolder viewHolder, int i) {
     final  listing list= listing.get(i);
        viewHolder.listName.setText(list.getListname());
        viewHolder.distance.setText(""+list.getDistance());
    }


    @Override
    public int getItemCount() {

        if(listing !=null){
            return listing.size();
        }
        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView listName;
        public final TextView distance;
        public final View view;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            listName = view.findViewById(R.id.textViewName);
            distance = view.findViewById(R.id.textViewDistance);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, ""+listName+distance, Toast.LENGTH_SHORT).show();
        }
    }


    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }


    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}

