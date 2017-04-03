package com.example.mobility.myplaces;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mobility on 03/04/17.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<NearByPlaces> nearByPlacesArrayList;
    private Context mContext;

    public DataAdapter(Context context, ArrayList<NearByPlaces> nearByPlacesArrayList) {
        this.nearByPlacesArrayList = nearByPlacesArrayList;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nearby_list,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        NearByPlaces currentObject = nearByPlacesArrayList.get(position);
        if(currentObject.getRating()>=0 &&currentObject.getRating()<=5){
            //holder.placeRating.setNumStars((int) currentObject.getRating());
            holder.placeRating.setRating(currentObject.getRating());
        }else{
            //holder.placeRating.setNumStars(0);
            holder.placeRating.setRating(0);
        }
        holder.placeName.setText(currentObject.getPlaceName());
       // holder.placePhonenumber.setText(currentObject.getPhoneNumber());
        holder.placePhonenumber.setText(currentObject.getPhoneNumber());
        holder.latitude.setText(String.valueOf( currentObject.getLatitude()));
        holder.longitude.setText(String.valueOf(currentObject.getLongitude()));

    }

    @Override
    public int getItemCount() {
        return nearByPlacesArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
       TextView placeName;
       // TextView placeLikelihood;
        TextView placePhonenumber;
        RatingBar placeRating;
        TextView latitude,longitude;
        ViewHolder(View view) {
            super(view);
           placePhonenumber = (TextView)view.findViewById(R.id.place_phone);
            placeRating = (RatingBar) view.findViewById(R.id.rating);
            placeName = (TextView)view.findViewById(R.id.place_name);
            latitude = (TextView)view.findViewById(R.id.latitude);
            longitude = (TextView)view.findViewById(R.id.longitude);
           // placeLikelihood = (TextView)view.findViewById(R.id.place_likelihood);

        }
    }
}
