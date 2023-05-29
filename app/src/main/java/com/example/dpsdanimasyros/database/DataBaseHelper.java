package com.example.dpsdanimasyros.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "FavoriteRecord.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME1 = "my_favorite1";
    private static final String THEME_ID = "_id3";
    private static final String THEME_TITLE3 = "theme_title";
    private static final String THEME_TIME = "theme.time";
    private static final String THEME_IMAGE = "theme_image";
    private static final String UNIQUE_ID = "unique_id";

    private Context context;

    public DataBaseHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query3 = "CREATE TABLE" + TABLE_NAME1 + " (" + THEME_ID + " STRING PRIMARY KEY, "
                + THEME_TITLE3 + "TEXT, " +
                THEME_TIME + " TEXT, " +
                THEME_IMAGE + " TEXT, " +
                UNIQUE_ID + " TEXT);";
        sqLiteDatabase.execSQL(query3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
