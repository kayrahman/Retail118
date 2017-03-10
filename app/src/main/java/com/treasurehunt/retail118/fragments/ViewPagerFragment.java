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

public class ViewPagerFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_viewpager,container,false);



        final MainFragment fragment=new MainFragment();
        final AllCategoryFragment allCategoryFragment=new AllCategoryFragment();
        final FragmentNewArrival newArrival=new FragmentNewArrival();
        final ActivityFragment activityFragment=new ActivityFragment();
        final FragmentHighLighted fragmentHighLighted=new FragmentHighLighted();
        final FragmentSpecialOffer fragmentSpecialOffer=new FragmentSpecialOffer();



        final ViewPager viewPager=(ViewPager)view.findViewById(R.id.viewPager);

        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
                                 @Override
                                 public Fragment getItem(int position) {

                                  if(position==0)
                                      return allCategoryFragment;
                                     else if (position==1)
                                      return fragmentHighLighted;
                                     else if(position==2)
                                      return newArrival;
                                     else if(position==3)
                                      return fragmentSpecialOffer;
                                     else if(position==4)
                                      return fragment;
                                     else
                                      return new Fragment();

                                 }

                                 @Override
                                 public int getCount() {
                                     return 6;
                                 }

                                 @Override
                                 public CharSequence getPageTitle(int position) {

                                     String tabName = " ";

                                     switch (position) {

                                         case 0:
                                             tabName = "ALL CATEGORY";
                                             break;
                                         case 1:
                                             tabName = "HIGHLIGHTS";
                                             break;
                                         case 2:
                                             tabName = "NEW ARRIVAL";
                                             break;
                                         case 3:
                                             tabName = "SPECIAL OFFER";
                                             break;
                                         case 4:
                                             tabName = "ACTIVITY";
                                             break;
                                         case 5:
                                             tabName = "ME";
                                             break;


                                     }
                                     return tabName;
                                 }
                             });

        TabLayout tabLayout=(TabLayout)view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }
        });
        return view;
    }
}
