package com.example.mobility.myplaces;

/**
 * Created by Mobility on 03/04/17.
 */

public class PlaceDetails {
    private String mAddress,mName,mPhoneNumber,mRating,mLatitude,mLongitude;

    public PlaceDetails(String mAddress, String mName, String mPhoneNumber, String mRating, String mLatitude, String mLongitude) {
        this.mAddress = mAddress;
        this.mName = mName;
        this.mPhoneNumber = mPhoneNumber;
        this.mRating = mRating;
        this.mLatitude = mLatitude;
        this.mLongitude = mLongitude;
    }

    public PlaceDetails() {

    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPhoneNumber() {
        return mPhoneNumber;
    }

    public void setmPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }

    public String getmRating() {
        return mRating;
    }

    public void setmRating(String mRating) {
        this.mRating = mRating;
    }

    public String getmLatitude() {
        return mLatitude;
    }

    public void setmLatitude(String mLatitude) {
        this.mLatitude = mLatitude;
    }

    public String getmLongitude() {
        return mLongitude;
    }

    public void setmLongitude(String mLongitude) {
        this.mLongitude = mLongitude;
    }
}
