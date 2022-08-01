package com.example.sqlitedbproj;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    Context context;

    private static final String DB_NAME = "menudb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "Menu";

    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String DESCRIPTION_COL = "description";
    private static final String PRICE_COL = "price";
    private static final String CALORIES_COL = "calories";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + DESCRIPTION_COL + " TEXT,"
                + PRICE_COL + " TEXT,"
                + CALORIES_COL + " TEXT);";
        db.execSQL(query);
    }

    public void addNewStudent(String name, String description, String price, String calories) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NAME_COL, name);
        values.put(DESCRIPTION_COL, description);
        values.put(PRICE_COL, price);
        values.put(CALORIES_COL, calories);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
