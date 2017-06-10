package com.lexmat.kitchenhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "Recipe.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "recipes";

    public static final String COL_1 = "name";
    public static final String COL_2 = "ingredientNames";
    public static final String COL_3 = "ingredientAmounts";
    public static final String COL_4 = "ingredientTypes";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + COL_1 + " TEXT PRIMARY KEY," + COL_2 + " TEXT," + COL_3 + " TEXT," + COL_4 + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
