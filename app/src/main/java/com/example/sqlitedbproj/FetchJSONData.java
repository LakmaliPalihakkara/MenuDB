package com.example.sqlitedbproj;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

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


public class FetchJSONData extends AsyncTask<Void,Void,Void>
{
    String data = "";
    String dataParsed = "";
    String singleParsed = "";
    Context context;
    String promo_code;
    String offer;
    String expiry_date;

    public FetchJSONData (Context context) {
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://jsonkeeper.com/b/HSL2");
            //Create a connection first
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //Create input stream to read data
            InputStream inputStream = httpURLConnection.getInputStream();
            //Create buffer reader to read data from input stream
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                //Read lines
                line = bufferedReader.readLine();
                data = data + line;
            }

            //Parsing data
            JSONArray JA = new JSONArray(data);
            for (int i = 0; i < JA.length(); i++) {
                JSONObject JO = (JSONObject) JA.get(i);
                promo_code = "promo_code:" + JO.get("promo_code");

                        offer = "offer:" + JO.get("offer");

                ;
                dataParsed = dataParsed + singleParsed;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Intent fetchDataIntent = new Intent(context, MainActivity.class);
        fetchDataIntent.putExtra("data", this.dataParsed.toString());
        context.startActivity(fetchDataIntent);
    }
}
