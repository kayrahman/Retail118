package com.treasurehunt.retail118.fragments;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;

import com.treasurehunt.retail118.R;
import com.treasurehunt.retail118.adapters.FragmentHighlightAdapter;
import com.treasurehunt.retail118.callback.MyInterface;
import com.treasurehunt.retail118.controller.RetriveData;
import com.treasurehunt.retail118.model.Product;

import java.util.ArrayList;

/**
 * Created by neel on 20/02/2017.
 */

public class FragmentNewArrival extends RetriveData {

    final String productUrl="http://retail118.com/index.php?route=api/product/getProducts";

   // private ArrayList<Product> mProducts=new ArrayList<>();


    @Override
    protected int getLayoutid() {
        return R.layout.fragment_recyclerview_newarrival;
    }

    @Override
    protected ArrayList<Product> getProds() {
        return mProducts ;
    }

    @Override
    protected void updateDisplay() {

        MyInterface listener=(MyInterface)getActivity();


        RecyclerView recyclerView=(RecyclerView)getActivity().findViewById(R.id.recyclerView_newArrival);
        //GridAdapter gridAdapter=new GridAdapter(listener,mProducts);
        FragmentHighlightAdapter gridAdapter=new FragmentHighlightAdapter(listener,getProds());

        recyclerView.setAdapter(gridAdapter);

        DisplayMetrics displayMetrics=getResources().getDisplayMetrics();
        float dpWidth= displayMetrics.widthPixels/displayMetrics.density;

        int numOfColumns=(int)(dpWidth/80);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);

    }

    @Override
    protected String getProductsUrl() {
        return productUrl;
    }
}
