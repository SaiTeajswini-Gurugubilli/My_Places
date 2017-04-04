package com.example.mobility.myplaces;

import android.graphics.Bitmap;



public class NearByPlaces {
    private String placeName;
    private String phoneNumber;
    private float rating;
    private double latitude,longitude;
    private Bitmap placeImage;
    private String address;

/*

    public NearByPlaces(String placeName, String phoneNumber, float rating, double latitude, double longitude, Bitmap placeImage, String address) {
        this.placeName = placeName;
        this.phoneNumber = phoneNumber;
        this.rating = rating;
        this.latitude = latitude;
        this.longitude = longitude;
        this.placeImage = placeImage;
        this.address = address;
    }
*/


    public NearByPlaces(String placeName, String phoneNumber, float rating, double latitude, double longitude) {
        this.placeName = placeName;
        this.phoneNumber = phoneNumber;
        this.rating = rating;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public NearByPlaces(String placeName, float likelihood, String phonenumber, float rating) {

        this.placeName = placeName;
        this.phoneNumber = phonenumber;
        this.rating = rating;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
/*
    public String getPhoneNumber() {
        return  phoneNumber;
    }

    public void setPhoneNumber(String image) {
        this. phoneNumber = image;
    }*/


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String  rating) {
        this.phoneNumber = rating;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Bitmap getPlaceImage() {
        return placeImage;
    }

    public String getAddress() {
        return address;
    }




    /*--------------------SelectedPlacesDetails----------------*/
    /*package com.example.mobility.myplaces;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SelectedPlaceDetails extends AppCompatActivity {


    private ImageView placeimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_place_details);
        Bitmap mImage = getIntent().getExtras().getParcelable("image");
        String mName = getIntent().getStringExtra("name");
        String mAddress = getIntent().getStringExtra("address");
        String mPhone = getIntent().getStringExtra("phone");
       TextView nametxt = (TextView)findViewById(R.id.name);
       TextView addresstxt = (TextView)findViewById(R.id.address);
       TextView phonetxt = (TextView)findViewById(R.id.phonenumber);
        ImageView placeimg = (ImageView)findViewById(R.id.place_photo);
        nametxt.setText(mName);
        addresstxt.setText(mAddress);
        phonetxt.setText(mPhone);
        placeimg.setImageBitmap(mImage);
    }
}*/
/*------------------------SelectedDetails XML File---------------------------*/
    /*<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <ImageView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/place_photo"/>
    <android.support.v7.widget.CardView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="5dp"
        android:background="@color/colorPrimary"
        android:elevation="10dp">
        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:id="@+id/name"
            android:textStyle="bold"
            android:textAppearance="@style/TextAppearance.AppCompat.Title"/>
    </android.support.v7.widget.CardView>
<RelativeLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal"
    android:layout_marginTop="5dp">
    <ImageButton
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/ic_call"
        android:id="@+id/call"
        android:background="@color/transparent"/>
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/call"
        android:text="@string/call"
        android:textStyle="bold"/>
    <ImageButton
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/make_fav"
        android:src="@drawable/ic_star"
        android:background="@color/transparent"
        android:layout_centerHorizontal="true"/>
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/make_fav"
        android:text="@string/favourite"
        android:layout_centerHorizontal="true"
        android:textStyle="bold"/>
</RelativeLayout>

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/address"
        android:textAppearance="@style/TextAppearance.AppCompat.Subhead"/>
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/phonenumber"/>
</LinearLayout>*/


}
