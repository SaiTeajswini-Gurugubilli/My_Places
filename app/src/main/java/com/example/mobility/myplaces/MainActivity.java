package com.example.mobility.myplaces;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihood;
import com.google.android.gms.location.places.PlaceLikelihoodBuffer;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoMetadataBuffer;
import com.google.android.gms.location.places.PlacePhotoMetadataResult;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlacePicker;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int place_picker = 1000;
    int permission_request_code= 100;
    private GoogleApiClient mGoogleApiClient;
    private TextView textview;
    ArrayList<NearByPlaces> mNearByPlaces;
    private RecyclerView recyclerview;
    ArrayList<PlaceDetails> mPlaceDetails;
    int current;
    TextView latText,lngTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGoogleApiClient = new GoogleApiClient.Builder(this).addApi(Places.GEO_DATA_API).addApi(Places.PLACE_DETECTION_API).build();
        recyclerview = (RecyclerView)findViewById(R.id.rv);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerview.setLayoutManager(layoutManager);
        mNearByPlaces = new ArrayList<>();


    }

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

 /*   public void placePicker(View view) {
        try {
            PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
            startActivityForResult(builder.build(this), place_picker);
        } catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }
*/
    public void currentPlace(View view) {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},permission_request_code);
            return;
        }else {
            callPlaceDetectionApi();
        }
    }

    private void callPlaceDetectionApi() throws SecurityException{
        PendingResult<PlaceLikelihoodBuffer> result = Places.PlaceDetectionApi.getCurrentPlace(mGoogleApiClient, null);
        result.setResultCallback(new ResultCallback<PlaceLikelihoodBuffer>() {
            Place places=null;
            @Override
            public void onResult(@NonNull PlaceLikelihoodBuffer placeLikelihoods) {
                for(PlaceLikelihood placeLikelihood :placeLikelihoods){
                   Log.i("TAG",String.format("Place '%s' with"+"likelihood : '%g' latitude: '%g' and logitude : '%g' and id '%s'",placeLikelihood.getPlace().getName(),placeLikelihood.getLikelihood(),placeLikelihood.getPlace().getLatLng().latitude,placeLikelihood.getPlace().getLatLng().longitude,placeLikelihood.getPlace().getId()));
                   /* PlacePhotoMetadataResult result = Places.GeoDataApi.getPlacePhotos(mGoogleApiClient, placeLikelihood.getPlace().getId()).await();
                    PlacePhotoMetadataBuffer buffer = null;
                    if (result != null && result.getStatus().isSuccess()) {
                        buffer = result.getPhotoMetadata();
                    }
                    PlacePhotoMetadata photo = buffer.get(0);
                    Bitmap image = photo.getPhoto(mGoogleApiClient).await().getBitmap();*/
                   // Bitmap image = BitmapFactory.decodeResource(getResources(),R.drawable.image1);
                   // mNearByPlaces.add(new NearByPlaces((String)placeLikelihood.getPlace().getName(),(String)placeLikelihood.getPlace().getPhoneNumber(),placeLikelihood.getPlace().getRating(),placeLikelihood.getPlace().getLatLng().latitude,placeLikelihood.getPlace().getLatLng().longitude, (String) placeLikelihood.getPlace().getAddress()));

                    mNearByPlaces.add(new NearByPlaces((String)placeLikelihood.getPlace().getName(),(String)placeLikelihood.getPlace().getPhoneNumber(),placeLikelihood.getPlace().getRating(),placeLikelihood.getPlace().getLatLng().latitude,placeLikelihood.getPlace().getLatLng().longitude));
               //places = placeLikelihood.getPlace();
                    //places.GeoDataApi
                   // Places.GeoDataApi.getPlacePhotos(mGoogleApiClient,places.getId()).await();
                }
                RecyclerView.Adapter adapter = new DataAdapter(getBaseContext(),mNearByPlaces);
                recyclerview.setAdapter(adapter);
                placeLikelihoods.release();
            }
        });
    }

   /*   public void autoComplete(View view) {


    }*/

/*  @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == place_picker){
            if(resultCode == RESULT_OK){
                Place place = PlacePicker.getPlace(this,data);
                StringBuilder stBuilder  = new StringBuilder();
                String placename = String.format("%s",place.getName());
                String latitude = String.valueOf(place.getLatLng().latitude);
                String longitude = String.valueOf(place.getLatLng().longitude);
                String address = String.format("%s",place.getAddress());
                String rating = String.format("%s",place.getRating());
                String phonenumber = String.format("%s",place.getPhoneNumber());

                           //    mPlaceDetails.add(new PlaceDetails(address,placename,phonenumber,rating,latitude,longitude));

               // current = mPlaceDetails.get(mPlaceDetails.size()-1);

                stBuilder.append("Name: ");
                stBuilder.append(placename);
                stBuilder.append("\n");
                stBuilder.append("latitude: ");
                stBuilder.append(latitude);
                stBuilder.append("\n");
                stBuilder.append("longitude: ");
                stBuilder.append(longitude);
                stBuilder.append("\n");
                stBuilder.append("Address: ");
                stBuilder.append(address);
                stBuilder.append("\n");
                stBuilder.append("Rating: ");
                stBuilder.append(rating);
                stBuilder.append("\n");
                stBuilder.append("Phone Number: ");
                stBuilder.append(phonenumber);
                 TextView textview = (TextView)findViewById(R.id.txtview);
            *//*   PlaceDetails placeDetails = mPlaceDetails.get(mPlaceDetails.size()-1);
                textview.setText("Name : "+placeDetails.getmName()+"\n"+"Address : "+placeDetails.getmAddress()+"\n"+"Phone Number : "+placeDetails.getmPhoneNumber()+"\n"+"Rating : "+placeDetails.getmRating());

*//*
                textview.setText(stBuilder.toString());

            }
        }
    }*/
}
