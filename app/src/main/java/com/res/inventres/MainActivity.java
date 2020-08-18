package com.res.inventres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.res.inventres.data.CardsContract;
import com.res.inventres.data.CardsDBHelper;

public class MainActivity extends AppCompatActivity {

    CardsDBHelper dbHelper;
    EditText editTextMultiLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new CardsDBHelper(this);
        editTextMultiLine = findViewById(R.id.editTextMultiLine);
        ContentValues values = new ContentValues();
        values.put(CardsContract.CardsEntry.COLUMN_STICKER, "АУ01623");
        values.put(CardsContract.CardsEntry.COLUMN_DEV_TYPE, "Системный блок");
        values.put(CardsContract.CardsEntry.COLUMN_DEV_MODEL, "Проц, ОЗУ, HDD, video");
        values.put(CardsContract.CardsEntry.COLUMN_FIO, "Кудряшов М.В.");
        values.put(CardsContract.CardsEntry.COLUMN_N_N, "ААААААААА");

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        database.insert(CardsContract.CardsEntry.TABLE_NAME, null, values);
        Cursor cursor = database.query(CardsContract.CardsEntry.TABLE_NAME, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String sticker = cursor.getString(cursor.getColumnIndex(CardsContract.CardsEntry.COLUMN_STICKER)) + '\n';
            String dev_type = cursor.getString(cursor.getColumnIndex(CardsContract.CardsEntry.COLUMN_DEV_TYPE)) + '\n';
            String dev_model = cursor.getString(cursor.getColumnIndex(CardsContract.CardsEntry.COLUMN_DEV_MODEL)) + '\n';
            String fio = cursor.getString(cursor.getColumnIndex(CardsContract.CardsEntry.COLUMN_FIO)) + '\n';
            String n_n = cursor.getString(cursor.getColumnIndex(CardsContract.CardsEntry.COLUMN_N_N)) + '\n';

            editTextMultiLine.setText(sticker);
            editTextMultiLine.setText(dev_type);
            editTextMultiLine.setText(dev_model);
            editTextMultiLine.setText(fio);
            editTextMultiLine.setText(n_n);
        }
        cursor.close();

    }
}