package com.treasurehunt.retail118.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;
import com.facebook.share.widget.ShareDialog;
import com.treasurehunt.retail118.R;
import com.treasurehunt.retail118.callback.MyInterface;

import java.net.InterfaceAddress;
import java.util.zip.Inflater;

/**
 * Created by neel on 20/01/2017.
 */

public class LoginFragment extends Fragment {

    private LoginButton fbLoginBtn;
    private Button imgShareBtn;


    public TextView hello_txt;



    public interface MyAwesomeInterface{
         void onFbBtnClick();
         void onImgShareBtnClick();
         void onLikeBtnClick();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_login,container,false);

        hello_txt=(TextView)view.findViewById(R.id.txt_hello);

        fbLoginBtn=(LoginButton)view.findViewById(R.id.btn_fbLogin);
        imgShareBtn=(Button)view.findViewById(R.id.btn_imgShareFb);

        final MyAwesomeInterface mInterface= (MyAwesomeInterface) getActivity();

        fbLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInterface.onFbBtnClick();
            }
        });

        imgShareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mInterface.onImgShareBtnClick();
            }
        });

        return view;
    }
}
