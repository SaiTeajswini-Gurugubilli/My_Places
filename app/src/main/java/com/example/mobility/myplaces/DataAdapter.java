package com.example.mobility.myplaces;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoMetadataBuffer;
import com.google.android.gms.location.places.PlacePhotoMetadataResult;
import com.google.android.gms.location.places.Places;

import java.util.ArrayList;

/**
 * Created by Mobility on 03/04/17.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private  ArrayList<NearByPlaces> nearByPlacesArrayList;
    private Context mContext;
   /* private Place mPlace;
    private GoogleApiClient mGoogleApiClient;*/

    public DataAdapter(Context context, ArrayList<NearByPlaces> nearByPlacesArrayList) {
        this.nearByPlacesArrayList = nearByPlacesArrayList;
        this.mContext = context;
        /*this.mPlace = places;
        this.mGoogleApiClient = mGoogleApiClient;*/
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

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
       TextView placeName;
       // TextView placeLikelihood;
        TextView placePhonenumber;
        RatingBar placeRating;
        TextView latitude,longitude;
        Button imgbtn;
        ViewHolder(View view) {
            super(view);
           view.setOnClickListener(this);

           placePhonenumber = (TextView)view.findViewById(R.id.place_phone);
            placeRating = (RatingBar) view.findViewById(R.id.rating);
            placeName = (TextView)view.findViewById(R.id.place_name);
            latitude = (TextView)view.findViewById(R.id.latitude);
            longitude = (TextView)view.findViewById(R.id.longitude);
            imgbtn = (Button)view.findViewById(R.id.imagebtn);
            imgbtn.setOnClickListener(this);
           // placeLikelihood = (TextView)view.findViewById(R.id.place_likelihood);

        }

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.imagebtn) {
                NearByPlaces currentplace = nearByPlacesArrayList.get(getAdapterPosition());
                double lat, lng;
                lat = currentplace.getLatitude();
                lng = currentplace.getLongitude();
                String geoUri = "http://maps.google.com/maps?q=loc:" + lat + "," + lng;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Toast.makeText(mContext, String.valueOf(nearByPlacesArrayList.size()), Toast.LENGTH_SHORT).show();
                mContext.startActivity(intent);
            }             /*   Intent intent = new Intent(mContext, SelectedPlaceDetails.class);
else {
                NearByPlaces currentplace = nearByPlacesArrayList.get(getAdapterPosition());
                String address = currentplace.getAddress();
                String phonenumber =  currentplace.getPhoneNumber();
                //Bitmap image =currentplace.getPlaceImage();
                String name = currentplace.getPlaceName();
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               //intent.putExtra("image",image);
                intent.putExtra("name",name);
                intent.putExtra("Address",address);
                intent.putExtra("phone",phonenumber);
                mContext.startActivity(intent);*/
            }
        }
    }

