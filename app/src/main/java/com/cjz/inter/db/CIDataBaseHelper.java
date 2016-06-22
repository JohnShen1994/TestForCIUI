package com.cjz.inter.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/6/21.
 *
 */
public class CIDataBaseHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "Blackname.db";
    private static final int DATABASE_VERSION = 2;

    private static final String create_black = "CREATE TABLE black("+
            "_id INTEGER PRIMARY KEY,"+
            "black_num TEXT,"+
            "black_name TEXT"+");";

    public CIDataBaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_black);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table black");

        onCreate(db);
    }
}
