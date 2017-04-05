package com.example.mobility.myplaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class RetriveAll extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrive_all);
        DataBaseHandler db = new DataBaseHandler(this);
        ArrayList<NearByPlaces> allEmployes = db.retiveAll();

        final ListView ta = (ListView)findViewById(R.id.rows);
        ta.setAdapter(new DetailsTableAdapter(this,allEmployes));
    }
}
