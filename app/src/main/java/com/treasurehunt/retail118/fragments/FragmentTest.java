package com.treasurehunt.retail118.fragments;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.treasurehunt.retail118.R;
import com.treasurehunt.retail118.adapters.GridAdapter;
import com.treasurehunt.retail118.callback.MyInterface;
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
 * Created by neel on 01/11/2016.
 */

public class FragmentTest extends Fragment  {

    //Product[] mProducts;
    ArrayList<Product> mProducts=new ArrayList<>();



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_recyclerview_allcategory,container,false);


        final String getProductsUrl="http://retail118.com/index.php?route=api/product/getProducts";



        if(isNetworkAvailable()){
            OkHttpClient client=new OkHttpClient();
            Request request=new Request.Builder()
                    .url(getProductsUrl)
                    .build();

            Call call =client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                    alertUserAboutError();

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {


                    try {
                        String jsonData=response.body().string();

                        mProducts=getProducts(jsonData);



                        if (response.isSuccessful()) {

                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    updateDisplay();

                                }
                            });

                        } else {
                            alertUserAboutError();
                        }
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            });

        }



        return view;

    }



    public void updateDisplay(){


       // MenuFragments.OnMenuSelectedInterface listener= (MenuFragments.OnMenuSelectedInterface) getActivity();
        MyInterface listener=(MyInterface)getActivity();


        RecyclerView recyclerView=(RecyclerView)getActivity().findViewById(R.id.recyclerView);
        GridAdapter gridAdapter=new GridAdapter(listener,mProducts);
        recyclerView.setAdapter(gridAdapter);

        DisplayMetrics displayMetrics=getResources().getDisplayMetrics();
        float dpWidth= displayMetrics.widthPixels/displayMetrics.density;

        int numOfColumns=(int)(dpWidth/120);

        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getActivity(),numOfColumns);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);


    }

    public boolean isNetworkAvailable() {

        ConnectivityManager manager=(ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo=manager.getActiveNetworkInfo();
        boolean isAvailable=false;
        if(networkInfo!=null && networkInfo.isConnected()){
            isAvailable=true;
        }
        return isAvailable;

    }

    public ArrayList <Product> getProducts(String jsonData) throws JSONException {

        JSONObject retailProducts=new JSONObject(jsonData);
        JSONObject obj1=retailProducts.getJSONObject("success");

        Product[] products=new Product[obj1.length()];
        ArrayList<Product> productArrayList=new ArrayList<>();


        Iterator<String> iter=obj1.keys();
        while(iter.hasNext()) {
            String key = iter.next();

            Object object = obj1.get(key);
            String name1 = object.toString();


            JSONObject jsonObject = obj1.getJSONObject(key);
            String name = jsonObject.getString("name");


            Product product=new Product();
            product.setProductId(jsonObject.getString("product_id"));
            product.setProductName(jsonObject.getString("name"));
            product.setImage(jsonObject.getString("image"));
            product.setManufacturer(jsonObject.getString("manufacturer"));
            product.setPrice(jsonObject.getString("price"));
            product.setViewed(jsonObject.getString("viewed"));

            productArrayList.add(product);



        }
        return productArrayList;

    }

    public void alertUserAboutError() {
        AlertDialogFragment dialog=new AlertDialogFragment();
        FragmentTransaction ft= getFragmentManager().beginTransaction();
        dialog.show(ft,"error_dialog");

    }



}
