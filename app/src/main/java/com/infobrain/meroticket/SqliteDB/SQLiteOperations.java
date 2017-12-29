package com.infobrain.meroticket.SqliteDB;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.infobrain.meroticket.SqliteDB.DBHelper.COLUMN_ID;
import static com.infobrain.meroticket.SqliteDB.DBHelper.COLUMN_LOCATION;
import static com.infobrain.meroticket.SqliteDB.DBHelper.TABLE_LOCATION;

/**
 * Created by frank on 12/17/2017.
 */

public class SQLiteOperations {
    DBHelper dbHelper;
    SQLiteOpenHelper dbhandler;
    SQLiteDatabase database;
    int i;

    public SQLiteOperations(SQLiteOpenHelper dbhandler, SQLiteDatabase database) {
        this.dbhandler = dbhandler;
        this.database = database;
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCATION);
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_LOCATION + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY, " +
                COLUMN_LOCATION + " VARCHAR" + ")");
    }

    //ADDING LOCATION OPERATION/METHOD
    public void addLocation(String location) {

        SQLiteDatabase db = this.database;
        ContentValues values = new ContentValues();

        Log.e("COLUMN ID", COLUMN_ID);
        Log.e("COLUMN_LOCATION", COLUMN_LOCATION);

        values.put(COLUMN_LOCATION, location);

        db.insert(TABLE_LOCATION, null, values);

        i++;
        Log.e("Counter",String.valueOf(i));
//        Log.e("Main InsertID", String.valueOf(insertid));

    }


}
