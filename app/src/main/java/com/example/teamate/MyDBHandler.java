package com.example.teamate;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

import androidx.annotation.Nullable;

import com.example.teamate.data.Account;

public class MyDBHandler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "account.db";
    public static final String TABLE_NAME = "account_table";
    public static final String COL_FNAME = "FirstName";
    public static final String COL_LNAME = "LastName";
    public static final String COL_EMAIL = "Email";
    public static final String COL_PASS = "Password";

    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
        public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" ("+COL_FNAME+" TEXT,"+COL_LNAME+" TEXT,"+COL_EMAIL+" TEXT PRIMARY KEY,"+COL_PASS+" TEXT)",null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME,null);
        onCreate(db);
    }

    public boolean insertData(Account account) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_FNAME, account.getFirstName());
        contentValues.put(COL_LNAME, account.getLastName());
        contentValues.put(COL_EMAIL, account.getEmail());
        contentValues.put(COL_FNAME, account.getPassword());
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " +TABLE_NAME, null);
        return res;
    }

    public Account findAccount(String accountEmail) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " +TABLE_NAME+" where "+COL_EMAIL+" = " + "'" + accountEmail + "'", null);
        Account account;
        if (res != null) {
            res.moveToFirst();
            account = new Account(res.getString(0), res.getString(1), res.getString(2), res.getString(3));
        } else {
            account = null;
        }
        return account;
    }
}