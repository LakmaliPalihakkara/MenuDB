package com.example.sqlitedbproj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
    Button offers_button, add_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_menu);
        dbHelper = new DBHelper(DisplayMenu.this);
        db = dbHelper.getReadableDatabase();
        menu_grid_view = findViewById(R.id.menu_grid_view);
        offers_button = findViewById(R.id.offers);
        add_button = findViewById(R.id.add);

        loadMenu();

        offers_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FetchJSONData process = new FetchJSONData(v.getContext());
                process.execute();
            }
        });

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DisplayMenu.this, CreateMenu.class);
                startActivity(intent);

                finish();
            }
        });
    }
    private void loadMenu()
    {
        dataModalArrayList = dbHelper.getMenu(db);
        DisplayMenuAdapter adapter = new DisplayMenuAdapter(DisplayMenu.this, dataModalArrayList, dbHelper, this);
        menu_grid_view.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }
}