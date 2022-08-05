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
    Button updateButton;

    private DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_menu);

        updateName = findViewById(R.id.edit_name);
        updateDescription = findViewById(R.id.edit_description);
        updatePrice = findViewById(R.id.et_price);
        updateCalories = findViewById(R.id.et_calories);

        updateButton = findViewById(R.id.bt_update);

        dbHelper = new DBHelper(UpdateMenu.this);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = updateName.getText().toString();
                String description = updateDescription.getText().toString();
                String price = updatePrice.getText().toString();
                String calories = updateCalories.getText().toString();

                dbHelper.updateMenuItem(name, description, price, calories);


                Toast.makeText(UpdateMenu.this, "Update Menu Item", Toast.LENGTH_SHORT).show();
                updateName.setText("");
                updateDescription.setText("");
                updatePrice.setText("");
                updateCalories.setText("");

                Intent intent = new Intent(UpdateMenu.this, DisplayMenu.class);
                startActivity(intent);
            }
        });
    }
}