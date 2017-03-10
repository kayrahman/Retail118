package com.treasurehunt.retail118.database;

import android.provider.BaseColumns;

/**
 * Created by neel on 24/02/2017.
 */

public final class RetailDbContract {

    public RetailDbContract(){}


    public static final class  AllCatProdEntry implements BaseColumns {

        public final static String TABLE_NAME="allProducts";
        public final static String ID=BaseColumns._ID;
        public final static String COLUMN_PRODUCT_NAME="name";
        public final static String COLUMN_PRODUCT_PRICE="price";
        public final static String COLUMN_PRODUCT_IMAGE="image";


    }


}
