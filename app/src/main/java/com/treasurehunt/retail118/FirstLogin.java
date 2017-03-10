package com.treasurehunt.retail118;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by neel on 27/10/2016.
 */

public class FirstLogin {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;


    public FirstLogin(Context context){

        this.context=context;
        pref=context.getSharedPreferences("first",0);
        editor=pref.edit();

    }

    public void setFirst(Boolean isFirst){

        editor.putBoolean("check",isFirst);
        editor.commit();

    }

    public boolean Check(){

        return pref.getBoolean("check",true);

    }


}
