package com.example.teamate.data;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

public class MyDBHandler extends SQLiteOpenHelper {
    //information of database
    private static final int DATABASE_VERSION = 1;
    private static final String ACCOUNT_DATABASE = "accountDB.db";
    public static final String TABLE_NAME = "Account";
    public static final String COLUMN_FNAME = "FirstName";
    public static final String COLUMN_LNAME = "LastName";
    public static final String COLUMN_EMAIL = "Email";
    public static final String COLUMN_UNAME = "UserName";
    //initialize the database
    public MyDBHandler(Context context, Stringname, SQLiteDatabase.CursorFactoryfactory, intversion) {
        super(context, ACCOUNT_DATABASE, factory, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE" + TABLE_NAME + "(" + COLUMN_FNAME + "INTEGER PRIMARYKEY," + COLUMN_LNAME + "TEXT," + COLUMN_EMAIL + "TEXT," + COLUMN_UNAME + "TEXT )";
        db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}
    public String loadHandler() {}
    public void addHandler(Student student) {}
    public Student findHandler(String studentname) {}
    public boolean deleteHandler(int ID) {}
    public boolean updateHandler(int ID, String name) {}
}