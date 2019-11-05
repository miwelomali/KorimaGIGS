package com.example.exa2_restaurantes;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RestDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Restaurants.db";

    public RestDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Comandos SQL
        db.execSQL("CREATE TABLE " + RestContract.RestEntry.TABLE_NAME + " ("
                + RestContract.RestEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + RestContract.RestEntry.ID + " TEXT NOT NULL,"
                + RestContract.RestEntry.NAME + " TEXT NOT NULL,"
                + RestContract.RestEntry.LOCATION + " TEXT NOT NULL,"
                + RestContract.RestEntry.DESCRIPTION + " TEXT NOT NULL,"
                + RestContract.RestEntry.RATING + " DOUBLE NOT NULL,"
                + "UNIQUE (" + RestContract.RestEntry.ID + "))");

        ContentValues values = new ContentValues();

        // Pares clave-valor
        values.put(RestContract.RestEntry.ID, "1");
        values.put(RestContract.RestEntry.NAME, "Chihuas");
        values.put(RestContract.RestEntry.LOCATION, "Colonia centro");
        values.put(RestContract.RestEntry.DESCRIPTION, "Tacos mamalones");
        values.put("3.0", RestContract.RestEntry.RATING);

        // Insertar...
        db.insert(RestContract.RestEntry.TABLE_NAME, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVer, int newVer) {

    }
}
