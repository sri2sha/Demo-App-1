package com.example.dempapp1;

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
    public static final String EMPLOYEE_NAME = "employee_name";
    public static final String EMPLOYEE_ID = "employee_id";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table TABLE_NAME(employeeName TEXT primary key, employeeId TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists TABLE_NAME");
    }

    public Boolean insertEmployeeData(String employee_name, String employee_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("employeeName", employee_name);
        contentValues.put("employeeId", employee_id);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public Boolean updateEmployeeData(String employee_name, String employee_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("employeeId", employee_id);
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("select * from TABLE_NAME where employee_name = ?", new String[]{employee_name});
        if (cursor.getCount() >= 0) {
            long result = db.update(TABLE_NAME, contentValues, "employeeName=?", new String[]{employee_name});
            return result != -1;
        }return false;
    }

    public Boolean deleteEmployeeData(String employee_name) {
        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("select * from TABLE_NAME where name = ?", new String[]{employee_name});
        if (cursor.getCount() >= 0) {
            long result = db.delete(TABLE_NAME, "employeeName=?", new String[]{employee_name});
            return result != -1;
        }return false;
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from Employeedetails",null);
    }

}
