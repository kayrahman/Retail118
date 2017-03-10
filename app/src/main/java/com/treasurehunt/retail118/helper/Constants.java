package com.treasurehunt.retail118.helper;

import android.graphics.Color;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by neel on 28/12/2016.
 */

public class Constants {

    public static final class HTTP{

    public static final String BASE_URL="http://retail118.com/";

        //http://retail118.com/



    }

    public static void changeStatusBarColor(Window window){

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

            // Window window=getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }


}
