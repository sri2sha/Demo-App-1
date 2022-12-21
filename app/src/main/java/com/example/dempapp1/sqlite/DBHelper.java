package com.example.dempapp1.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "TABLE_NAME";
    public static final String DB_NAME = "EMLOYEES.DB";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table TABLE_NAME(employeeName TEXT, employeeId TEXT primary key)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists TABLE_NAME");
    }

    public Boolean insertEmployeeData(String employeeName, String employeeId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("employeeName", employeeName);
        contentValues.put("employeeId", employeeId);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public Boolean updateEmployeeData(String employeeName,String employeeId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("employeeName", employeeName);
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("select * from TABLE_NAME where employeeId = ?", new String[]{employeeName});
        if (cursor.getCount() >= 0) {
            long result = db.update(TABLE_NAME, contentValues, "employeeName=?", new String[]{employeeName});
            return result != -1;
        }return false;
    }

    public Boolean deleteEmployeeData(String employeeId) {
        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("select * from TABLE_NAME where employeeId = ?", new String[]{employeeId});
        if (cursor.getCount() >= 0) {
            long result = db.delete(TABLE_NAME, "employeeId=?", new String[]{employeeId});
            return result != -1;
        }return false;
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from TABLE_NAME",null);
        return cursor;
    }

}
