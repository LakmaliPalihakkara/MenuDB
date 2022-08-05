package com.example.sqlitedbproj;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayMenu extends AppCompatActivity {
    GridView menu_grid_view;
    ArrayList<DataModel> dataModalArrayList;
    private DBHelper dbHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_menu);
        dbHelper = new DBHelper(DisplayMenu.this);
        db = dbHelper.getReadableDatabase();
        menu_grid_view = findViewById(R.id.menu_grid_view);
        loadMenu();
        Toast.makeText(DisplayMenu.this, "data loaded ", Toast.LENGTH_SHORT).show();
    }
    private void loadMenu()
    {
        dataModalArrayList = dbHelper.getMenu(db);
        DisplayMenuAdapter adapter = new DisplayMenuAdapter(DisplayMenu.this, dataModalArrayList, dbHelper);
        menu_grid_view.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }
}