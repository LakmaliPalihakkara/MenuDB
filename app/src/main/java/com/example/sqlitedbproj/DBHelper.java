package com.example.sqlitedbproj;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

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

    public void addMenuItem(String name, String description, String price, String calories) {

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

public ArrayList<DataModel> getMenu(SQLiteDatabase db)
{
    ArrayList<DataModel> dataModalArrayList = new ArrayList<>();
    // Define a projection that specifies which columns from the database
    // you will actually use after this query.
    String[] projection = {ID_COL,NAME_COL,DESCRIPTION_COL,PRICE_COL,CALORIES_COL};
    // Filter results WHERE "title" = 'My Title'
    String selection = " = ?";;
    String[] selectionArgs = { "*" };

    // How you want the results sorted in the resulting Cursor
    String sortOrder =
           ID_COL + " DESC";
    Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    String str="";
    while(cursor.moveToNext()) {
        String id = cursor.getString(
                cursor.getColumnIndexOrThrow(ID_COL));
        String name = cursor.getString(
                cursor.getColumnIndexOrThrow(NAME_COL));
        String description = cursor.getString(
                cursor.getColumnIndexOrThrow(DESCRIPTION_COL));
        String calories = cursor.getString(
                cursor.getColumnIndexOrThrow(CALORIES_COL));
        String price = cursor.getString(
                cursor.getColumnIndexOrThrow(PRICE_COL));
        str = str + " " + id + " " + description;
        DataModel datamodel = new DataModel(name,description,price,calories,id);
        dataModalArrayList.add(datamodel);
    }
    cursor.close();
    return dataModalArrayList;
}
        public void deleteMenuItem(String menuItemName) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NAME, "id=?", new String[]{menuItemName});
        db.close();
    }

        public void updateMenuItem(String menuItemName) {

         SQLiteDatabase db = this.getWritableDatabase();
         ContentValues values = new ContentValues();

         db.update(TABLE_NAME, values,"id=?", new String[]{menuItemName});
         db.close();

       }


}
