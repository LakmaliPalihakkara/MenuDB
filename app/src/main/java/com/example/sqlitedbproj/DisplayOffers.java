package com.example.sqlitedbproj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class DisplayOffers extends AppCompatActivity {
    ArrayList<OffersDataModel> offers_list;
    String promo_code;
    String offer;
    String expiry_date;
    Button close;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_offers);
        String data = getIntent().getStringExtra("data");
        TextView menu= findViewById(R.id.title);
        close = findViewById(R.id.bt_close);

        String str="";
      try {
        offers_list = new ArrayList<>();
        JSONArray JA = null;
            JA = new JSONArray(data);
        for (int i = 0; i < JA.length(); i++) {
            JSONObject JO = (JSONObject) JA.get(i);
            promo_code = "Promo Code: " + JO.get("promo_code");

            offer = "" + JO.get("offer");
            expiry_date="Expires on " + JO.get("expiry_date");
            str = str + promo_code;
            offers_list.add(new OffersDataModel(promo_code,offer,expiry_date));
        }
            FetchJSONAdapter adapter = new FetchJSONAdapter(DisplayOffers.this, offers_list);
            GridView offer_grid_view = findViewById(R.id.offers_grid_view);
            offer_grid_view.setAdapter(adapter);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(DisplayOffers.this, e.toString(), Toast.LENGTH_SHORT).show();
        }


      close.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(DisplayOffers.this, DisplayMenu.class);
              startActivity(intent);

              finish();

          }
      });

    }
}