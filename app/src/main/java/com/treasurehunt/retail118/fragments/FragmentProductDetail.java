package com.treasurehunt.retail118.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.treasurehunt.retail118.R;
import com.treasurehunt.retail118.model.Product;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static com.treasurehunt.retail118.controller.RetriveData.mProducts;

/**
 * Created by neel on 06/03/2017.
 */

public class FragmentProductDetail extends Fragment {

    public static final String KEY_INDEX="key_index";

    private ArrayList<Product>productList=new ArrayList<>();
    private TextView mProdDesc;
    private TextView mProdPrice;
    private ImageView mProdImage;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.pr_detail,container,false);

        int index=getArguments().getInt(KEY_INDEX);


        mProdDesc=(TextView)view.findViewById(R.id.lbl1);
        mProdImage=(ImageView)view.findViewById(R.id.imageView1);
        mProdPrice=(TextView)view.findViewById(R.id.price);

        productList=mProducts;

       /* Log.i("FROM PRODUCTLIST",productList.get(index).getProductName());
        Log.i("FROM PRODUCTArray",mProducts.get(index).getProductName());*/



        mProdDesc.setText(mProducts.get(index).getProductName());
        mProdPrice.setText(mProducts.get(index).getPrice());
       Picasso.with(getContext())
                .load("http://retail118.com/image"+mProducts.get(index).getImage())
                //.load("http://image.tmdb.org/t/p/w500/"+movieNowPlaying[position].getPoster())
                .placeholder(R.drawable.placeholder2)
                .into(mProdImage);

        return view;
    }
}
