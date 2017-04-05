package com.example.mobility.myplaces;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.widget.TextView;

import java.util.ArrayList;


public class DataBaseHandler extends SQLiteOpenHelper {
    public static final int version = 1;
    public static final String name = "Place";

    public static final String table_name = "place_Details";
    public static final String place_id = "id";
    public static final String place_name = "name";
    public static final String place_address = "address";
    public static final String place_phone = "phone";
    public static final String place_rating = "rating";
    public static final String place_Uri = "uri";


    public DataBaseHandler(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + table_name + "(" + place_id + " TEXT PRIMARY KEY," + place_name + " TEXT," + place_phone + " TEXT," + place_rating + " TEXT," + place_Uri + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);

    }

    public void addPlace(String mId, String mName, String mPhone, String mRating, String mWebsite) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(place_id, mId);
        values.put(place_name, mName);
        values.put(place_phone, mPhone);
        values.put(place_rating, mRating);
        values.put(place_Uri, mWebsite);
        db.insert(table_name, null, values);
        db.close();
    }

    public ArrayList<NearByPlaces> retiveAll() {
        ArrayList<NearByPlaces> list = new ArrayList<>();
        String selectQuery = "select * from " + table_name;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                NearByPlaces place = new NearByPlaces();
                place.setPlaceId(cursor.getString(0));
                place.setPlaceName(cursor.getString(1));
                place.setPhoneNumber(cursor.getString(2));
                place.setRating(Float.parseFloat(cursor.getString(3)));
                place.setWebsiteUri(Uri.parse(cursor.getString(4)));
                list.add(place);
            } while (cursor.moveToNext());
        }
        return list;
    }
}

