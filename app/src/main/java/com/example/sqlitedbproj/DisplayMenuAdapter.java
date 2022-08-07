package com.example.sqlitedbproj;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DisplayMenuAdapter extends ArrayAdapter<DataModel> {

    ArrayList<DataModel> dataModalArrayList;
    DBHelper dbHelper;
    DisplayMenu displayMenu;

    // constructor for our list view adapter.
    public DisplayMenuAdapter(@NonNull Context context, ArrayList<DataModel> dataModalArrayList, DBHelper dbHelper, DisplayMenu displayMenu) {
        super(context, 0, dataModalArrayList);

        this.dataModalArrayList = dataModalArrayList;
        this.dbHelper = dbHelper;
        this.displayMenu = displayMenu;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // below line is use to inflate the layout for our item of list view.
        View listitemView = convertView;
        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.menu_gv_item, parent, false);
        }

        // after inflating an item of listview item we are getting data from array list inside our modal class.
        DataModel dataModal = getItem(position);

        // initializing our UI components of list view item.
        TextView name = listitemView.findViewById(R.id.name);
        TextView description = listitemView.findViewById(R.id.description);
        TextView calories = listitemView.findViewById(R.id.calories);
        TextView price = listitemView.findViewById(R.id.price);
        ImageView edit = listitemView.findViewById(R.id.edit);
        ImageView delete = listitemView.findViewById(R.id.delete);
        // after initializing our items we are setting data to our view. below line is use to set data to our text view.
        name.setText(dataModal.getName());
        description.setText(dataModal.getDescription());
        calories.setText(dataModal.getCalories()+" calories");
        price.setText("$" + dataModal.getPrice());

        // in below line we are using Picasso to load image from URL in our Image VIew below line is use to add item click listener for our item of list view.
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),UpdateMenu.class);
                i.putExtra("Name", dataModal.getName());
                i.putExtra("Id",dataModal.getId());
                i.putExtra("Description",dataModal.getDescription());
                i.putExtra("Price",dataModal.getPrice());
                i.putExtra("Calories",dataModal.getCalories());
                getContext().startActivity(i);
                displayMenu.finish();


            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setCancelable(true);
                builder.setTitle("Confirm");
                builder.setMessage("Are you sure you want to delete " + dataModal.getName()+"?");
                builder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(getContext(),DisplayMenu.class);
                                i.putExtra("Name", dataModal.getName());
                                i.putExtra("Id",dataModal.getId());
                                i.putExtra("Description",dataModal.getDescription());
                                i.putExtra("Price",dataModal.getPrice());
                                i.putExtra("Calories",dataModal.getCalories());
                                getContext().startActivity(i);

                                dbHelper.deleteMenuItem(dataModalArrayList.get(position).getId());
                                displayMenu.finish();
                            }
                        });
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();




            }
        });

        return listitemView;
    }
}

