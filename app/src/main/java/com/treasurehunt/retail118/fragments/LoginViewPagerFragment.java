package com.treasurehunt.retail118.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.treasurehunt.retail118.R;

/**
 * Created by neel on 02/11/2016.
 */

public class LoginViewPagerFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_viewpager,container,false);



        //final MainFragment fragment=new MainFragment();
        final LoginFragment loginFragment=new LoginFragment();
        final LoginFragment signUpFragment=new LoginFragment();



        ViewPager viewPager=(ViewPager)view.findViewById(R.id.viewPager);

        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
                                 @Override
                                 public Fragment getItem(int position) {

                                  if(position==0)
                                      return loginFragment;
                                     else
                                      return new Fragment();


                                 }

                                 @Override
                                 public int getCount() {
                                     return 2;
                                 }

                                 @Override
                                 public CharSequence getPageTitle(int position) {

                                     String tabName = " ";

                                     switch (position) {

                                         case 0:
                                             tabName = "LOGIN";
                                             break;
                                         case 1:
                                             tabName = "SIGNUP";
                                             break;


                                     }
                                     return tabName;
                                 }
                             });

        TabLayout tabLayout=(TabLayout)view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }
}
