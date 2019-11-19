package com.appsfromholland.sqlitecrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class MetingManager extends SQLiteOpenHelper {

    //private ArrayList<Meting> metingen;

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "SLIMME_METER";
    private static final String TABLE_NAME = "meting";
    private static final String KEY_UNIT= "unit";
    private static final String KEY_VALUE = "value";

    // CREATE TABLE meting (unit TEXT, value INTEGER);
    private static final String CREATE_TABLE=
            "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY_UNIT + " TEXT, " +
                    KEY_VALUE + " INTEGER);";

    public MetingManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //this.metingen = new ArrayList<Meting>();
    }

    public void create(Meting meting){

        ContentValues values = new ContentValues();
        values.put(KEY_UNIT, meting.unit.toString());
        values.put(KEY_VALUE, String.valueOf(meting.value));
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);

    }

    public ArrayList<Meting> read(){

        SQLiteDatabase db = this.getReadableDatabase();

        //https://www.programcreek.com/java-api-examples/?class=android.database.sqlite.SQLiteDatabase&method=rawQuery
        //Cursor cursor = db.rawQuery("SELECT * FROM meting WHERE unit = ?", new String[]{"WATT"});
        Cursor cursor = db.rawQuery("SELECT * FROM meting;", new String[]{});

        ArrayList<Meting> metingen = new ArrayList<Meting>();
        if( cursor.moveToFirst() ) {
            do {
                String unit = cursor.getString(0);
                int value = cursor.getInt(1);
                metingen.add(new Meting(Unit.valueOf(unit), value));
            } while (cursor.moveToNext());
        }

        return metingen;
    }

    public void update() {
    }

    public void delete() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " +  TABLE_NAME);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
        Log.i("","onCreate: " + CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " +  DATABASE_NAME);
        onCreate(sqLiteDatabase);
    }
}
