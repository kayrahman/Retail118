package com.treasurehunt.retail118.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;

import com.treasurehunt.retail118.R;
import com.treasurehunt.retail118.adapters.GridAdapter;
import com.treasurehunt.retail118.callback.MyInterface;
import com.treasurehunt.retail118.controller.RetriveData;
import com.treasurehunt.retail118.database.RetailDataSource;
import com.treasurehunt.retail118.model.Product;

import java.util.ArrayList;

/**
 * Created by neel on 01/11/2016.
 */

public class AllCategoryFragment extends RetriveData {

    ArrayList<Product> testProducts=new ArrayList<>();


    final String productUrl="http://retail118.com/index.php?route=api/product/getProducts";

    private RetailDataSource mDataSource;

    @Override
    protected int getLayoutid() {
        return R.layout.fragment_recyclerview_allcategory;
    }

    @Override
    protected ArrayList<Product> getProds() {
        return mProducts;
    }

    @Override
    protected void updateDisplay() {

        MyInterface listener=(MyInterface)getActivity();


        RecyclerView recyclerView=(RecyclerView)getActivity().findViewById(R.id.recyclerView);
        GridAdapter gridAdapter=new GridAdapter(listener,mProducts);
       // Log.i("ArrayList:",mProducts.toString());

       // FragmentHighlightAdapter gridAdapter=new FragmentHighlightAdapter(listener,getProds());

        recyclerView.setAdapter(gridAdapter);

        DisplayMetrics displayMetrics=getResources().getDisplayMetrics();
        float dpWidth= displayMetrics.widthPixels/displayMetrics.density;

        int numOfColumns=(int)(dpWidth/160);

        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getActivity(),numOfColumns);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);



    }

    @Override
    protected String getProductsUrl() {
        return productUrl;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mDataSource=new RetailDataSource(getActivity());
        mDataSource.open();
  //      mDataSource.insertAllProducts(mProducts);

        testProducts=mDataSource.readProdFromDb();



  //      Log.i("ArrayList Product:",testProducts.get(1).getProductName());
    }

    @Override
    public void onPause() {
        super.onPause();

   //    mDataSource.close();
    }

}
