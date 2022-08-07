package com.example.sqlitedbproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateMenu extends AppCompatActivity {
    EditText updateName, updateDescription, updatePrice, updateCalories;
    Button updateButton, closeButton;

    String id, name, description, price, calories;

    private DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_menu);

        updateName = findViewById(R.id.edit_name);
        updateDescription = findViewById(R.id.edit_description);
        updatePrice = findViewById(R.id.edit_price);
        updateCalories = findViewById(R.id.edit_calories);

        updateButton = findViewById(R.id.bt_update);
        closeButton = findViewById(R.id.bt_close);

        dbHelper = new DBHelper(UpdateMenu.this);


        Intent intent = getIntent();

        if(intent != null) {

            id = intent.getStringExtra("Id");
            name = intent.getStringExtra("Name");
            description = intent.getStringExtra("Description");
            price = intent.getStringExtra("Price");
            calories = intent.getStringExtra("Calories");

            updateName.setText(name);
            updateDescription.setText(description);
            updatePrice.setText(price);
            updateCalories.setText(calories);
        }

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                dbHelper.updateMenuItem(id,updateName.getText().toString(),updateDescription.getText().toString(), updatePrice.getText().toString(), updateCalories.getText().toString());

                Toast.makeText(UpdateMenu.this, "Update Menu Item", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(UpdateMenu.this, DisplayMenu.class);
                startActivity(intent);
                finish();
            }
        });


        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(UpdateMenu.this, DisplayMenu.class);
                startActivity(intent);

                finish();
            }
        });
    }
}