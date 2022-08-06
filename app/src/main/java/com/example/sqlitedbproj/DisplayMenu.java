package com.example.sqlitedbproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayMenu extends AppCompatActivity {
    GridView menu_grid_view;
    ArrayList<DataModel> dataModalArrayList;
    private DBHelper dbHelper;
    SQLiteDatabase db;
    Button offers_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_menu);
        dbHelper = new DBHelper(DisplayMenu.this);
        db = dbHelper.getReadableDatabase();
        menu_grid_view = findViewById(R.id.menu_grid_view);
        offers_button = findViewById(R.id.offers);
        loadMenu();

        offers_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FetchJSONData process = new FetchJSONData(v.getContext());
                process.execute();
            }
        });
    }
    private void loadMenu()
    {
        dataModalArrayList = dbHelper.getMenu(db);
        DisplayMenuAdapter adapter = new DisplayMenuAdapter(DisplayMenu.this, dataModalArrayList);
        menu_grid_view.setAdapter(adapter);
    }
}