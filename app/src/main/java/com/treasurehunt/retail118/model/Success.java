package com.treasurehunt.retail118.model;

import com.google.gson.annotations.Expose;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Success{

	@SerializedName("68")
	@Expose
	private JsonMember68 jsonMember68;

	@SerializedName("69")
	@Expose
	private JsonMember69 jsonMember69;

	@SerializedName("63")
	@Expose
	private JsonMember63 jsonMember63;

	public void setJsonMember68(JsonMember68 jsonMember68){
		this.jsonMember68 = jsonMember68;
	}

	public JsonMember68 getJsonMember68(){
		return jsonMember68;
	}

	public void setJsonMember69(JsonMember69 jsonMember69){
		this.jsonMember69 = jsonMember69;
	}

	public JsonMember69 getJsonMember69(){
		return jsonMember69;
	}

	public void setJsonMember63(JsonMember63 jsonMember63){
		this.jsonMember63 = jsonMember63;
	}

	public JsonMember63 getJsonMember63(){
		return jsonMember63;
	}
}