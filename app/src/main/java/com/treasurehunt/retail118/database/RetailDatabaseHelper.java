package com.treasurehunt.retail118.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.treasurehunt.retail118.database.RetailDbContract.AllCatProdEntry;

/**
 * Created by neel on 23/02/2017.
 */

public class RetailDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME="retail118";
    private static final int DB_VERSION=2;

    private static String CREATE_ALLPRODUCTS=
            "CREATE TABLE "+AllCatProdEntry.TABLE_NAME+"("+AllCatProdEntry.ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+AllCatProdEntry.COLUMN_PRODUCT_NAME+" TEXT,"+ AllCatProdEntry.COLUMN_PRODUCT_PRICE+" TEXT,"+ AllCatProdEntry.COLUMN_PRODUCT_IMAGE+" BLOB)";

          //  "CREATE TABLE allProducts(ID INTEGER PRIMARY KEY,name TEXT NOT NULL,price TEXT NOT NULL,image TEXT NOT NULL)";


    public RetailDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_ALLPRODUCTS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
