package com.treasurehunt.retail118.callback;

import com.treasurehunt.retail118.model.JsonMember63;
import com.treasurehunt.retail118.model.Product;
import com.treasurehunt.retail118.model.Response;
import com.treasurehunt.retail118.model.Success;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by neel on 28/12/2016.
 */

public interface Retail118Retrofit {

    @GET("/index.php/?route=api/product/getProducts")
    Call<JsonMember63> getAllProducts();

    ///index.php?route=api/product/getProducts
}
