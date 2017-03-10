package com.treasurehunt.retail118.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.security.PublicKey;

/**
 * Created by neel on 07/11/2016.
 */

public class Product  {

    @SerializedName("id")
    @Expose
    private String mProductId;
    @SerializedName("name")
    @Expose
    private String mProductName;
    @SerializedName("email")
    @Expose
    private String mPrice;
    @SerializedName("image")
    @Expose
    private String mImage;
    @SerializedName("manufacturer")
    @Expose
    private String mManufacturer;
    @SerializedName("viewed")
    @Expose
    private String mViewed;

    public Product(){}

    public Product(String cId,String Name,String Email){

        mProductId=cId;
       mProductName=Name;
        mPrice=Email;
    }

    public Product(String productId, String productName, String price, String image) {
        mProductId = productId;
        mProductName = productName;
        mPrice = price;
        mImage = image;
    }

    public String getProductId() {
        return mProductId;
    }

    public void setProductId(String productId) {
        mProductId = productId;
    }

    public String getProductName() {
        return mProductName;
    }

    public void setProductName(String productName) {
        mProductName = productName;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public String getManufacturer() {
        return mManufacturer;
    }

    public void setManufacturer(String manufacturer) {
        mManufacturer = manufacturer;
    }

    public String getViewed() {
        return mViewed;
    }

    public void setViewed(String viewed) {
        mViewed = viewed;
    }
}
