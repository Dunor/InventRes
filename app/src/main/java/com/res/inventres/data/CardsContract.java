package com.res.inventres.data;

import android.provider.BaseColumns;

public class CardsContract {
    public static final class CardsEntry implements BaseColumns {
        public static final String TABLE_NAME = "cards";
        public static final String COLUMN_STICKER = "sticker";
        public static final String COLUMN_DEV_TYPE = "dev_type";
        public static final String COLUMN_DEV_MODEL = "dev_model";
        public static final String COLUMN_FIO = "fio";
        public static final String COLUMN_N_N = "n_n";

        public static final String TYPE_TEXT = "TEXT";
        public static final String TYPE_INTEGER = "INTEGER";

        public static final String CREATE_COMMAND = "CREATE TABLE IF NOT EXIST" + TABLE_NAME +
                "(" + _ID + " " + TYPE_INTEGER + " PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_STICKER + " " + TYPE_TEXT + ", " +
                COLUMN_N_N + " " + TYPE_TEXT + ", " +
                COLUMN_DEV_TYPE + " " + TYPE_TEXT + ", " +
                COLUMN_DEV_MODEL + " " + TYPE_TEXT + ", " +
                COLUMN_FIO + " " + TYPE_TEXT + ")";

        public static final String DROP_COMMAND = "DROP TABLE IF EXIST " + TABLE_NAME;
    }
}
