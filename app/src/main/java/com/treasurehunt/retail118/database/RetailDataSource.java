package com.treasurehunt.retail118.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.treasurehunt.retail118.model.Product;
import com.treasurehunt.retail118.database.RetailDbContract.AllCatProdEntry;

import java.util.ArrayList;

/**
 * Created by neel on 23/02/2017.
 */

public class RetailDataSource {

    private SQLiteDatabase mDatabase;
    private RetailDatabaseHelper mHelper;
    private Context mContext;

    public RetailDataSource(Context context){
        this.mContext=context;
        mHelper=new RetailDatabaseHelper(mContext);

    }

    public void open(){
        mDatabase=mHelper.getWritableDatabase();

    }
    public void close(){
        mDatabase.close();
    }

    public void insertAllProducts(ArrayList<Product> productList){
        //open();
        try{

            for(Product product:productList){
                ContentValues cv=new ContentValues();
                cv.put("PRODUCT NAME",product.getProductName());
                cv.put("PRODUCT PRICE",product.getPrice());
                cv.put("PRODUCT IMAGE",product.getImage());

                mDatabase.insert(AllCatProdEntry.TABLE_NAME,null,cv);
            }

            mDatabase.setTransactionSuccessful();
            mDatabase.endTransaction();
            close();


        }catch (SQLiteException e){

        }

    }


    public ArrayList<Product> readProdFromDb(){
        open();

        Cursor cursor=mDatabase.query(
                AllCatProdEntry.TABLE_NAME,
                 new String[] {AllCatProdEntry.ID,AllCatProdEntry.COLUMN_PRODUCT_NAME,AllCatProdEntry.COLUMN_PRODUCT_PRICE,AllCatProdEntry.COLUMN_PRODUCT_PRICE},
                null,
                null,
                null,
                null,
                null

        );

        ArrayList<Product> productArrayList=new ArrayList<>();
        if(cursor.moveToFirst()) {
            do {

                Product product = new Product();
                product.setProductName(getStringFromColumnName(cursor, AllCatProdEntry.COLUMN_PRODUCT_NAME));
                product.setPrice(getStringFromColumnName(cursor, AllCatProdEntry.COLUMN_PRODUCT_PRICE));
                product.setImage(getStringFromColumnName(cursor, AllCatProdEntry.COLUMN_PRODUCT_IMAGE));

                productArrayList.add(product);
            } while (cursor.moveToNext());
        }

            cursor.close();
            mHelper.close();

            return productArrayList;


    }

    private String getStringFromColumnName(Cursor cursor, String columnName) {
        int coulmnIndex = cursor.getColumnIndex(columnName);
        String name = cursor.getString(coulmnIndex);
        return name;
    }

}
