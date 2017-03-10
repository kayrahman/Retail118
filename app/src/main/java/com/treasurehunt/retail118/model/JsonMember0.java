package com.treasurehunt.retail118.model;

import com.google.gson.annotations.Expose;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class JsonMember0{

	@SerializedName("min(price)")
	@Expose
	private Object minPrice;

	public void setMinPrice(Object minPrice){
		this.minPrice = minPrice;
	}

	public Object getMinPrice(){
		return minPrice;
	}
}