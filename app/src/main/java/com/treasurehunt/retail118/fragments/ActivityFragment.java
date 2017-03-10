package com.treasurehunt.retail118.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.facebook.share.widget.LikeView;
import com.treasurehunt.retail118.R;
import com.treasurehunt.retail118.activities.Main2;
import com.treasurehunt.retail118.callback.MyInterface;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by neel on 13/02/2017.
 */

public class ActivityFragment extends Fragment {


    LikeView mLikeView;
    TextView mTextView;
    Button mButton;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_activity,container,false);

        mLikeView=(LikeView)view.findViewById(R.id.btn_fbLike);
        mLikeView.setObjectIdAndType("https://www.facebook.com/retail118/",LikeView.ObjectType.OPEN_GRAPH);
        //mButton=(Button)view.findViewById(R.id.btn_like);


        mTextView=(TextView)view.findViewById(R.id.textActivity);

       final LoginFragment.MyAwesomeInterface  mMyAwesomeInterface= (LoginFragment.MyAwesomeInterface)getActivity();

        mLikeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMyAwesomeInterface.onLikeBtnClick();
                //Toast.makeText(getActivity(),"Like Button on the go",Toast.LENGTH_LONG).show();
                mTextView.setText("Like Button clicked");

            }
        });

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
    }
}
