package com.example.sqlitedbproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateMenu extends AppCompatActivity {

    EditText etName, etDescription, etPrice, etCalories;
    Button btCreate, btClose;

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_menu);

        etName = (EditText) findViewById(R.id.et_name);
        etDescription = (EditText) findViewById(R.id.et_description);
        etPrice = (EditText) findViewById(R.id.et_price);
        etCalories = (EditText) findViewById(R.id.et_calories);
        btCreate = (Button) findViewById(R.id.bt_create);
        btClose = (Button) findViewById(R.id.bt_close);

        dbHelper = new DBHelper(this);

        btCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = etName.getText().toString();
                String description =  etDescription.getText().toString();
                String price = etPrice.getText().toString();
                String calories = etCalories.getText().toString();

                if (name.isEmpty() || description.isEmpty() || price.isEmpty() || calories.isEmpty()) {
                    Toast.makeText(CreateMenu.this, "Please enter missing data..", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {

                    dbHelper.addMenuItem(name, description, price, calories);

                    Toast.makeText(CreateMenu.this, "Menu item has been added.", Toast.LENGTH_SHORT).show();
                    etName.setText("");
                    etDescription.setText("");
                    etPrice.setText("");
                    etCalories.setText("");

                    Intent intent = new Intent(CreateMenu.this, DisplayMenu.class);
                    startActivity(intent);
                }

            }
        });


        btClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateMenu.this, DisplayMenu.class);
                startActivity(intent);

                finish();
            }
        });
    }
}