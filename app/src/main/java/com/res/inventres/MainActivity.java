package com.res.inventres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.res.inventres.data.CardsContract;
import com.res.inventres.data.CardsDBHelper;

public class MainActivity extends AppCompatActivity {

    CardsDBHelper dbHelper;
    TextView textViewResult;
    EditText editTextText;
    String res = "err";
    String search = "?";
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new CardsDBHelper(this);
        dbHelper.onUpgrade(dbHelper.getWritableDatabase(), 1, 2);
        editTextText = findViewById(R.id.editTextText);
        textViewResult = findViewById(R.id.textViewResult);
        ContentValues values = new ContentValues();
        values.put(CardsContract.CardsEntry.COLUMN_STICKER, "АУ01623");
        values.put(CardsContract.CardsEntry.COLUMN_DEV_TYPE, "Системный блок");
        values.put(CardsContract.CardsEntry.COLUMN_DEV_MODEL, "Проц, ОЗУ, HDD, video");
        values.put(CardsContract.CardsEntry.COLUMN_FIO, "Кудряшов М.В.");
        values.put(CardsContract.CardsEntry.COLUMN_N_N, "ААААААААА");

        ContentValues values1 = new ContentValues();
        values1.put(CardsContract.CardsEntry.COLUMN_STICKER, "АУ0000");
        values1.put(CardsContract.CardsEntry.COLUMN_DEV_TYPE, "С/блок");
        values1.put(CardsContract.CardsEntry.COLUMN_DEV_MODEL, "Проц, ОЗУ, HDD, video1");
        values1.put(CardsContract.CardsEntry.COLUMN_FIO, "Иванов");
        values1.put(CardsContract.CardsEntry.COLUMN_N_N, "ББББББ");



        database = dbHelper.getWritableDatabase();
        database.insert(CardsContract.CardsEntry.TABLE_NAME, null, values);
        database.insert(CardsContract.CardsEntry.TABLE_NAME, null, values1);

    }

    protected void readFromDBBySticker(String search) {
        Cursor cursor = database.query(CardsContract.CardsEntry.TABLE_NAME, null, "sticker = ?", new String[] {search}, null, null, null);
        while (cursor.moveToNext()) {
            String sticker = cursor.getString(cursor.getColumnIndex(CardsContract.CardsEntry.COLUMN_STICKER)) + '\n';
            String dev_type = cursor.getString(cursor.getColumnIndex(CardsContract.CardsEntry.COLUMN_DEV_TYPE)) + '\n';
            String dev_model = cursor.getString(cursor.getColumnIndex(CardsContract.CardsEntry.COLUMN_DEV_MODEL)) + '\n';
            String fio = cursor.getString(cursor.getColumnIndex(CardsContract.CardsEntry.COLUMN_FIO)) + '\n';
            String n_n = cursor.getString(cursor.getColumnIndex(CardsContract.CardsEntry.COLUMN_N_N)) + "\n\n";

            res = sticker + dev_type + dev_model + fio + n_n;

        }
        cursor.close();
        textViewResult.setText(res);
    }

    public void Search(View view) {
        search = editTextText.getText().toString();
        readFromDBBySticker(search);
    }
}