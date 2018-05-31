package com.epam.mikle.realestateagentassistant.model.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.epam.mikle.realestateagentassistant.RealEstateApplication;

import static com.epam.mikle.realestateagentassistant.model.sqlite.DbConstants.*;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static SQLiteHelper helper = new SQLiteHelper(RealEstateApplication.getContext());

    public SQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION_ACTUAL);
    }

    public static SQLiteHelper getHelper() {
        return helper;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_QUERY_CREATE_TABLE_PLANNED_CALLS);
        sqLiteDatabase.execSQL(SQL_QUERY_CREATE_TABLE_PLANNED_MEETINGS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
