package com.example.sqlitedbproj;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class FetchJSONAdapter extends ArrayAdapter<OffersDataModel> {
    public FetchJSONAdapter(@NonNull Context context, ArrayList<OffersDataModel> dataModalArrayList) {
        super(context, 0, dataModalArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // below line is use to inflate the layout for item of list view.
        View listitemView = convertView;
        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.offers_gv_item, parent, false);
        }

        // after inflating an item of listview item can getting data from array list inside modal class.
        OffersDataModel dataModal = getItem(position);

        // initializing UI components of list view item.
        TextView code = listitemView.findViewById(R.id.promo_code);
        TextView offer = listitemView.findViewById(R.id.offer);
        TextView expiry_date = listitemView.findViewById(R.id.expiry_date);
        // after initializing our items can setting data to our view. below line is use to set data to our text view.
        code.setText(dataModal.getPromo_code());
        offer.setText(dataModal.getOffer());
        expiry_date.setText(dataModal.getExpiry_date());

        return listitemView;
    }
}
