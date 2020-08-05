package com.res.inventres.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CardsDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "cards.db";
    public static final int DB_VERSION = 1;

    public CardsDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CardsContract.CardsEntry.CREATE_COMMAND);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CardsContract.CardsEntry.DROP_COMMAND);
        onCreate(db);
    }
}
