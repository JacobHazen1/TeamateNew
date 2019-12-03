package com.example.teamate.data;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

public class MyDBHandler extends SQLiteOpenHelper {
    //information of database
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "accountDB.db";
    public static final String TABLE_NAME = "Account";
    public static final String COLUMN_FNAME = "FirstName";
    public static final String COLUMN_LNAME = "LastName";
    public static final String COLUMN_EMAIL = "Email";
    public static final String COLUMN_UNAME = "UserName";
    public static final String COLUMN_CID = "CompanyID";
    public static final String COLUMN_PASS = "Password";
    //initialize the database
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE" + TABLE_NAME + "(" + COLUMN_FNAME + "TEXT," + COLUMN_LNAME + "TEXT," + COLUMN_EMAIL + "TEXT," + COLUMN_UNAME + "TEXT PRIMARYKEY," + COLUMN_CID + "INTEGER," + COLUMN_PASS + "TEXT )";
        db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}
    public String loadHandler(String tableName) {
        String result = "";
        String query = "SELECT * FROM" + tableName;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            int result_0 = cursor.getInt(0);
            String result_1 = cursor.getString(1);
            result += String.valueOf(result_0) + " " + result_1 +
                    System.getProperty("line.separator");
        }
        cursor.close();
        db.close();
        return result;
    }
    public void addHandler(Account account) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_FNAME, account.getFirstName());
        values.put(COLUMN_LNAME, account.getLastName());
        values.put(COLUMN_EMAIL, account.getEmail());
        values.put(COLUMN_UNAME, account.getUsername());
        values.put(COLUMN_CID, account.getID());
        values.put(COLUMN_PASS, account.getPassword());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    //public Account findHandler(String accountFName) {}
    //public boolean deleteHandler(int ID) {}
    //public boolean updateHandler(int ID, String name) {}
}