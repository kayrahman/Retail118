package com.treasurehunt.retail118.fragments;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.treasurehunt.retail118.R;
import com.treasurehunt.retail118.adapters.FragmentHighlightAdapter;
import com.treasurehunt.retail118.adapters.GridAdapter;
import com.treasurehunt.retail118.callback.MyInterface;
import com.treasurehunt.retail118.controller.RetriveData;
import com.treasurehunt.retail118.model.Product;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by neel on 14/02/2017.
 */

public class FragmentHighLighted extends RetriveData {



    final String productUrl="http://retail118.com/index.php?route=api/product/getProducts";

    @Override
    protected int getLayoutid() {
        return R.layout.fragment_recyclerview_highlighted;
    }

    @Override
    protected ArrayList<Product> getProds() {
        return mProducts;
    }

    @Override
    protected void updateDisplay() {

        MyInterface listener=(MyInterface)getActivity();


        RecyclerView recyclerView=(RecyclerView)getActivity().findViewById(R.id.recyclerView_highlighted);
        //GridAdapter gridAdapter=new GridAdapter(listener,mProducts);
        FragmentHighlightAdapter gridAdapter=new FragmentHighlightAdapter(listener,getProds());

        recyclerView.setAdapter(gridAdapter);

        DisplayMetrics displayMetrics=getResources().getDisplayMetrics();
        float dpWidth= displayMetrics.widthPixels/displayMetrics.density;

        int numOfColumns=(int)(dpWidth/80);

        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getActivity(),numOfColumns);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);

    }

    @Override
    protected String getProductsUrl() {
        return productUrl;
    }
}
