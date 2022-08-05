package com.example.sqlitedbproj;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateMenuFragment extends Fragment {

    EditText etName, etDescription, etPrice, etCalories;
    Button btCreate;

    private DBHelper dbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_create_menu, container, false);

        etName = (EditText) view.findViewById(R.id.et_name);
        etDescription = (EditText) view.findViewById(R.id.et_description);
        etPrice = (EditText) view.findViewById(R.id.et_price);
        etCalories = (EditText) view.findViewById(R.id.et_calories);
        btCreate = (Button) view.findViewById(R.id.bt_create);

        dbHelper = new DBHelper(getContext());

        btCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = etName.getText().toString();
                String description =  etDescription.getText().toString();
                String price = etPrice.getText().toString();
                String calories = etCalories.getText().toString();

                if (name.isEmpty() || description.isEmpty() || price.isEmpty() || calories.isEmpty()) {
                    Toast.makeText(getContext(), "Please enter missing data..", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {

                dbHelper.addMenuItem(name, description, price, calories);

                Toast.makeText(getContext(), "Menu item has been added.", Toast.LENGTH_SHORT).show();
                etName.setText("");
                etDescription.setText("");
                etPrice.setText("");
                etCalories.setText("");

                    Intent intent = new Intent(getActivity(), DisplayMenu.class);
                    startActivity(intent);
                }

            }
        });

        return view;
    }
}