package com.infobrain.meroticket.SqliteDB;

import android.app.ProgressDialog;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Handler;

/**
 * Created by frank on 12/17/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "locationData.db";
    private static final String DATABASE_NAME_PART = "locationData";

    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }


    public static final String TABLE_LOCATION = "location";

    public static final String COLUMN_ID = "loc_id";
    public static final String COLUMN_LOCATION = "loc_name";

    private static final String CREATE_LOCATION_TABLE =

            "CREATE TABLE " + TABLE_LOCATION + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY UNIQUE, " +
                    COLUMN_LOCATION + " VARCHAR" + ")";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_LOCATION_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCATION);
        sqLiteDatabase.execSQL(CREATE_LOCATION_TABLE);
    }


/*
    final ProgressDialog progressDialog = new ProgressDialog(getApplicationContext());
        progressDialog.setMessage("Loading...");
        progressDialog.show();
    Runnable runnable= new Runnable() {
        @Override
        public void run() {
            progressDialog.cancel();
        }
    };
    Handler handler= new Handler();
        handler.postDelayed(runnable,3000);*/


}
