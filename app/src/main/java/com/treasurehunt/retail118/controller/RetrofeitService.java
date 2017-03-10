package com.treasurehunt.retail118.controller;

import com.treasurehunt.retail118.callback.Retail118Retrofit;
import com.treasurehunt.retail118.helper.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by neel on 28/12/2016.
 */

public class RetrofeitService {

    private Retail118Retrofit mService;

    public Retail118Retrofit getService(){
        if(mService==null){

            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl(Constants.HTTP.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mService=retrofit.create(Retail118Retrofit.class);

        }

        return mService;

    }


}
