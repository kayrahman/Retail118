package com.treasurehunt.retail118.utils;

import android.view.MotionEvent;
import android.view.View;

/**
 * Created by neel on 10/03/2017.
 */

public class TouchEffect implements View.OnTouchListener {
    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if(event.getAction()==0){
            v.setAlpha(0.7F);
        }
        for(int i=0;i<3;i++)
        {
            if((event.getAction()==1) || (event.getAction()==3)){
                    v.setAlpha(1.0F);
            }
        }

        return true;

    }

}
